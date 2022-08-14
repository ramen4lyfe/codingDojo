from cgitb import text
from crypt import methods
from nis import cat
from xmlrpc.client import boolean
from click import password_option
from flask import Blueprint, render_template, request, flash

auth = Blueprint('auth',__name__)

@auth.route('/login',methods=['GET','POST'])
def login():
    data = request.form
    print(data)
    return render_template("login.html",boolean=True)

@auth.route('/logout')
def logout():
    return render_template("/")

@auth.route('/sign_up',methods=['GET','POST'])
def sign_up():
    if request.method == 'POST':
        email = request.form.get('email')
        firstName = request.form.get('firstName')
        password1 = request.form.get('password1')
        password2 = request.form.get('password2')

        if len(email) > 4:
            flash('Email too short. Must be greater than 4 characters.', category='error')
        elif len(firstName) <2:
            flash('First name must be greater than 2 character', category='error')
        elif password1 != password2:
            flash('Password don\' match', category = 'error')
        elif len(password1) < 7:
            flash('Password too short', category = 'error')
        else:
            #add user to database
            flash('Account created!',category='success')

    return render_template("sign_up.html")

