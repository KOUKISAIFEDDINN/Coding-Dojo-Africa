from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key = 'shhh, this is a secret to share with anyone' # set a secret key for security purposes



@app.route('/')
def index():
    # Increment visit count
    session['tt'] = session.get('tt',0) + 1
    return render_template('index2.html', tt=session['tt'])
#* VIEW ROUTE
@app.route("/visit")
def display_page():
    session["counter"]=0
    return render_template("index.html")
@app.route('/')
def link_btn():
    # Increment visit count
    return redirect("/visit")
    
#* VIEW ROUTE
@app.route("/increment")
def increment():
    session["counter"]+=1
    return render_template("index.html")
#* VIEW ROUTE
@app.route("/reset")
def reset_counter():
    return redirect("/visit")    


if __name__ == "__main__":
    app.run(debug=True)