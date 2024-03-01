from flask_app.config.mysqlconnection import connectToMySQL
DATABASE = "users_add"
class User:
    def __init__(self,data) :
        self.id=data["id"]
        self.first_name=data["first_name"]
        self.last_name=data["last_name"]
        self.email=data["email"]
        
    @classmethod
    def get_all(cls):
        query= "SELECT * FROM users;"
        results=connectToMySQL(DATABASE).query_db(query)

        user_instances = []
        if results:
            for row in results:
                one_user = User(row)
                user_instances.append(one_user)
            return user_instances
        
        return []
    @classmethod
    def save(cls,data):
        query= """
                insert into users (first_name,last_name,email) 
                VALUE (%(first_name)s,%(last_name)s,%(email)s);
                """
        result=connectToMySQL(DATABASE).query_db(query,data)
        return result
    
    @classmethod
    def get_one_by_id(cls,data):
        query="""
            SELECT * FROM users
            WHERE id = %(id)s;
                """
        result=connectToMySQL(DATABASE).query_db(query,data)

        return User(result[0])


    @classmethod
    def update(cls,data):
        query="""
            UPDATE users
            SET first_name=%(first_name)s,last_name=%(last_name)s,email=%(email)s
            WHERE id =%(id)s
            """
        return connectToMySQL(DATABASE).query_db(query,data)

    @classmethod
    def delete(cls, data):
        query = """
            DELETE FROM users
            WHERE id = %(id)s
        """
        return connectToMySQL(DATABASE).query_db(query, data)

