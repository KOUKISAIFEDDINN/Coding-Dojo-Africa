from flask import Flask ,render_template,request,redirect
from users import User
app = Flask(__name__)    

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


if __name__=="__main__":    
    app.run(debug=True)    

