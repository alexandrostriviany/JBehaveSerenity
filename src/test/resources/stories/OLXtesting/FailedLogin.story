Meta:

Narrative:
As a system
I want to check user credentials
So that I can to prevent intruders


Scenario: Scenario 1 - User enters invalid name and password
Given user is on the OLX login page
When user confirm invalid 'login' and 'password'
Then system shows error pass_error under 'password' field
Examples:
| login             | password | pass_error                      |
| invalid@gmail.com | 123456   | Неверный email-адрес или пароль |

Scenario: Scenario 2 - User enters invalid email
Given user is on the OLX login page
When user confirm invalid 'login' and 'password'
Then system shows error email_error under 'email' field
Examples:
| login             | password | email_error                  |
| invalidAgmail.com | 123456   | это не похоже на email-адрес |

Scenario: Scenario 3 - User enters only login
Given user is on the OLX login page
When user confirm invalid login
Then system shows error email_error under 'email' field
And system shows error pass_error under 'password' field
Examples:
| login             | password | email_error                  | pass_error                      |
| invalidAgmail.com | 123456   | это не похоже на email-адрес | Поле обязательно для заполнения |

Scenario: Scenario 4 - User doesnt enters any
Given user is on the OLX login page
When user click 'Войти' button
Then system shows several error messages 'errors'
Examples:
|errors|
|Поле обязательно для заполнения,Поле обязательно для заполнения|