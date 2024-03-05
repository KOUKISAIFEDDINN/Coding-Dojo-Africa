from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models.ninja import Ninja
from flask_app import DATABASE
class Dojo:
    def __init__(self,data):
        self.id = data["id"]
        self.name = data["name"]
        self.created_at = data["created_at"]
        self.updated_at = data["updated_at"]
        self.ninjas = []





    @classmethod
    def read_all_dojos(cls):
        query = "SELECT * FROM dojo ORDER BY id DESC"
        db_dojo = connectToMySQL(DATABASE).query_db(query)
        dojos = []
        for dojo in db_dojo:
            dojos.append(cls(dojo))
        
        return dojos






    @classmethod
    def create_dojo(cls,data):
        query = "INSERT INTO dojo (name) VALUES (%(name)s)"
        return connectToMySQL(DATABASE).query_db(query,data)



    @classmethod
    def read_dojo(cls,data):
        query = "SELECT * FROM dojo WHERE id = %(id)s"
        read_dojo = connectToMySQL(DATABASE).query_db(query,data)
        query = "SELECT * FROM ninjas WHERE dojo_id = %(id)s"
        ninjas = connectToMySQL(DATABASE).query_db(query,data)
        dojo = cls(read_dojo[0])
        for ninja in ninjas:
            dojo.ninjas.append(Ninja(ninja))
        return dojo

