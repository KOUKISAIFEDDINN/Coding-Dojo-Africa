from flask import Flask,redirect,render_template,session,request
import random
app =Flask(__name__)
app.secret_key="azerty azerety"
@app.route('/')
def index():
    if 'activities' not in session:
        session['gold']=0
        session['activities']=[]
    return render_template("index.html")

@app.route('/process_money',methods=["POST"])
def process_money():
    if request.form['building']=="farm":
        gold=random.randint(10,20)
    elif request.form['building']=="cave":
        gold=random.randint(5,10)
    elif request.form['building']=="house":
        gold=random.randint(2,5)
    elif request.form['building']=="casino":
        gold=random.randint(-50,50)
    session['gold']+=gold
    session['activities'].append(f"<p>Earned {gold} golds from the {request.form['building']}</p>")
    return redirect('/')

@app.route('/reset')
def reset():
    session.clear()
    return redirect
if __name__=="__main__":
    app.run(debug=True)