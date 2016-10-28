Narrative:
As a user
I want to search product from catalog
So that I can finde that i want

Scenario: Scenario-1 simple search
Given user on the OLX home page
When user search product by name велосипед
Then user sees велосипед in the list of normal-ads

Scenario: Scenario-2 User sees 5 ads
Given user on the OLX home page
When user search product by name iphone
Then system's responce contains five top-ads
