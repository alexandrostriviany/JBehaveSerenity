
Narrative:
As a system
I want to check user credentials
So that I can to prevent intruders

Scenario: User enters invalid name and password
Given user is on the OLX login page
When user confirm invalid <login> and <password>
Then system shows error <error_message>

Examples:
|login  |password| error_message|
|invalid@gmail.com|123456|Неверный email-адрес или пароль|