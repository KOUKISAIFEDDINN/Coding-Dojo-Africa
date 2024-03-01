from flask import Flask ,render_template,request,redirect
from flask_app.models.users import User
from flask_app import app

@app.route("/home")
def home():
    all_users=User.get_all()
    return render_template("home.html",all_users=all_users)

@app.route("/user/create")
def display_form():
    return render_template("newUser.html")

@app.route("/user/new", methods=["post"])
def add_user():
    User.save(request.form)
    
    return redirect("/home")

@app.route("/user/edit/<int:id>", methods=["get"])
def display_update_users(id):
    user_dict = {
        "id":id
    }
    one_user=User.get_one_by_id(user_dict)
    print("=====>",one_user)
    return render_template("edit.html",user=one_user)


@app.route("/user/update/<int:id>", methods=["post"])
def update_user(id):
    updated_user={
        "id":id,
        "first_name":request.form["first_name"],
        "last_name":request.form["last_name"],
        "email":request.form["email"],
    }
    User.update(updated_user)
    return redirect("/home")



@app.route("/user/delete/<int:id>")
def delete_user(id):
    User.delete({"id":id})
    return redirect("/home")


@app.route("/user/show/<int:id>")
def display_one_user(id):
    # fetch the car by id
    user_dict = {
        "id": id
    }
    one_user = User.get_one_by_id(user_dict)


    return render_template("oneuser.html", user=one_user)