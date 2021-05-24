@login

  Feature: Login

    Background:
      Given navigate and verify landing page
      When click Sign in button


    Scenario: I should be able to login successfully with valid credentials
      And Enter the valid credentials mobile "07380625850" and password "themodernmilkman"
      When click login
      Then verify successful login


    Scenario:Attempt to login with invalid phone number
      And Enter the valid credentials mobile "03380625850" and password "themodernmilkman"
      When click login
      Then verify "Error!" txt and detail "The Phone Number or Password is incorrect. Please enter valid login details."



    Scenario:Attempt to login with invalid password
      And Enter the valid credentials mobile "07380625850" and password "themodernmilkm"
      When click login
      Then verify "Error!" txt and detail "The Phone Number or Password is incorrect. Please enter valid login details."

    Scenario: Update account email
      And Enter the valid credentials mobile "07380625850" and password "themodernmilkman"
      When click login
      When click account icon
      Then verify account details page and click edit account
      And enter new email to email input and click save button
      Then verify email is updated
