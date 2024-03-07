from flask_app import app
from flask import  redirect, render_template, request, flash, session
from flask_app.models import recipe
from flask_app.models import user

@app.route("/recipes/new")
def display_new_recipe():
    if "user_id" not in session:
        return redirect("/")
    return render_template("create_new_recipes.html")


@app.route("/recipes")
def display_all_recipes():
    if "user_id" not in session:
        return redirect("/")
    data = {"id": session["user_id"]}
    current_user = user.User.get_by_id(data)
    if current_user:
        all_recipes_users = recipe.Recipe.get_all_with_users()
        return render_template("recipes.html", user_name=current_user.first_name, all_recipes = all_recipes_users)
    


#!updated recipe
@app.route('/recipes/process', methods=['POST'])
def create_new_recipes():
    if "user_id" not in session:
        return redirect("/")
    if not recipe.Recipe.validate_recipe(request.form):
        return redirect('/recipes/new')
    
    data = {
        **request.form,
        "under": request.form.get("under") if request.form.get("under") == "yes" else "no",
        "user_id": session["user_id"]
    }
    id = recipe.Recipe.create(data)
    print("---------somthing worng-------",id)
    return redirect(f'/recipes/{id}')



@app.route('/recipes/<int:id>')
def display_recipe(id):
    if "user_id" not in session:
        return redirect("/")
    data = {
        "id":id
    }
    one_recipe = recipe.Recipe.get_one_with_user(data)
    user_id = {"id": session["user_id"]}
    current_user = user.User.get_by_id(user_id)
    return render_template('view_recipe.html', recipe=recipe.Recipe.get_by_id(data), user_name=current_user.first_name, created_post = one_recipe)

# * View Route (Show the edit form)
@app.route('/recipes/edit/<int:id>')
def display_edit(id):
    if "user_id" not in session:
        return redirect("/")
    data = {"id": id}
    recipes = recipe.Recipe.get_by_id(data)
    date_made = recipes.date
    under = recipes.under 
    return render_template('edit_recipe.html', recipe = recipe.Recipe.get_by_id(data), date_made = date_made, under_value = under)

#! updated recipe
@app.route('/recipes/update/<int:id>', methods=['POST'])
def updated_recipes(id):
    if "user_id" not in session:
        return redirect("/")
    if not recipe.Recipe.validate_recipe(request.form):
        return redirect(f'/recipes/edit/{id}')
    data = {
        **request.form,
        "under": request.form.get("under") if request.form.get("under") == "yes" else "no",  
        "user_id": session["user_id"],
        "id": id
    }
    recipe.Recipe.update(data)
    return redirect('/recipes')

#! delete_recipe
@app.route('/delete/<int:id>', methods=['POST'])
def delete_recipe(id):
    if "user_id" not in session:
        return redirect("/")
    recipe.Recipe.delete_recipe(id)
    return redirect('/recipes')

