from flask import Flask 
app = Flask(__name__)   
@app.route('/')          
def hello_world():
    return 'Hello World!' 

@app.route("/dojo")          
def codingdojo():
    return 'Dojo' 

@app.route("/say/<name>")          
def hello(name):
    return f"hi {name} !" 

@app.route("/repeat/<int:num>/<hello>")          
def repeat(num,hello):
    return f" {num*hello} !" 

if __name__=="__main__":  
    app.run(debug=True)    

