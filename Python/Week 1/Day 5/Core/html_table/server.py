from flask import Flask, render_template

app = Flask(__name__)

@app.route('/')
def user_list():

    headers = ['first_name', 'last_name','full_name']
    
    users = [
    {'first_name' : 'Michael', 'last_name' : 'Choi',},
    {'first_name' : 'John', 'last_name' : 'Supsupin'},
    {'first_name' : 'Mark', 'last_name' : 'Guillen'},
    {'first_name' : 'KB', 'last_name' : 'Tonel'}
        ]
    for user in users:
        user['full_name'] = user['first_name']  + user['last_name']



    return render_template(
        'index.html',
        headers=headers,
        users=users
    )

if __name__ == '__main__':
    app.run(debug=True)