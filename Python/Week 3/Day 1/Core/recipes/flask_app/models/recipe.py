from flask_app.configs.mysqlconnection import connectToMySQL
from flask_app import DATABASE
from flask import flash
import re
from flask_app.models import user

EMAIL_REGEX = re.compile(r"^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$")


class Recipe:
    def __init__(self, data):
        self.id = data["id"]
        self.name = data["name"]
        self.description = data["description"]
        self.instructions = data["instructions"]
        self.date = data["date"]
        self.under = data["under"]
        self.created_at = data["created_at"]
        self.updated_at = data["updated_at"]
        self.user_id = data["user_id"]
    #!create_recipes
    @classmethod
    def create(cls, data):
        query = """
                INSERT INTO recipes (name, description, instructions, date, under, user_id)
                VALUES (%(name)s, %(description)s, %(instructions)s, %(date)s, %(under)s, %(user_id)s)
                """
        recipe_id = connectToMySQL(DATABASE).query_db(query, data)
        return recipe_id  
    #! get_all_with_users 
    @classmethod
    def get_all_with_users(cls):
        query = """
                    SELECT * FROM recipes
                    JOIN users ON recipes.user_id = users.id;
                """
        results = connectToMySQL(DATABASE).query_db(query)
        list_of_recipes = []
        for row in results:
            current_recipe = Recipe(row)
            users_fixed = {
                **row,
                "id": row["users.id"],
                "created_at": row["users.created_at"],
                "updated_at": row["users.updated_at"]
            }
            current_recipe.posted_by = user.User(users_fixed)
            list_of_recipes.append(current_recipe)
        return list_of_recipes
    #! get_one_with_user
    @classmethod
    def get_one_with_user(cls, data):
        query = """
                    SELECT * FROM recipes
                    JOIN users ON recipes.user_id = users.id
                    WHERE recipes.id = %(id)s
                """
        result = connectToMySQL(DATABASE).query_db(query, data)
        row = result[0]
        current_recipe = Recipe(row)
        users_fixed = {
                **row,
                "id": row["users.id"],
                "created_at": row["users.created_at"],
                "updated_at": row["users.updated_at"]
            }
        current_recipe.posted_by = user.User(users_fixed)
        return current_recipe
    #! get_by_id
    @classmethod
    def get_by_id(cls, data):
        query = "SELECT * FROM recipes WHERE id = %(id)s;"
        result = connectToMySQL(DATABASE).query_db(query, data)
        if result:
            return cls(result[0])  
        else:
            return None
    #! update_recipes_after_edit_or_create
    @classmethod
    def update(cls, data):
        query = """
                UPDATE recipes
                SET name = %(name)s, description = %(description)s, instructions = %(instructions)s,
                date = %(date)s, under = %(under)s
                WHERE id = %(id)s;
                """
        return connectToMySQL(DATABASE).query_db(query, data)
    #!delete_recipe
    @classmethod
    def delete_recipe(cls, id):
        query = "DELETE FROM recipes WHERE id = %(id)s;"
        connectToMySQL(DATABASE).query_db(query, {'id': id})
    #!validation_recipes
    @staticmethod
    def validate_recipe(data):
        is_valid = True
        if len(data["name"]) < 1:
            is_valid = False
            flash("name is required !", "recipes")
        if len(data["description"]) < 1:
            is_valid = False
            flash("description is required !", "recipes")
        if len(data["instructions"]) < 1:
            is_valid = False
            flash("instructions is required !", "recipes")
        if len(data["date"]) < 1:
            is_valid = False
            flash("date is required !", "recipes")
        if not data.get("under"): 
            is_valid = False
            flash("under 30 minutes ?, is required!", "recipes")
        return is_valid