from flask import Flask, render_template
app = Flask(__name__)

@app.route('/play/<int:nbr>/<string:color>')
def index(nbr,color):
    return render_template("index.html", box_nbr=nbr,color=color)	
if __name__=="__main__":
    app.run(debug=True)

