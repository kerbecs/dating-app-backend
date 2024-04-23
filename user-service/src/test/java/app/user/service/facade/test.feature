Feature: Test user connexions facade

  Background:
    Given We have 2 users
      | id            | userId | firstName | lastName | countryCode | city    | gender | imgUrl              | connexions | birthDate  | online |
      | AFVDFVFG48484 | 10L    | Eduard    | Mititiuc | MD          | Singera | MALE   | google.com/img1.png | 11L        | 11.09.2002 | true   |
      | TGRGRTGRG8878 | 11L    | John      | Bree     | USA         | Detroit | MALE   | google.com/img2.png | 10L        | 25.02.2001 | true   |
    When An user uses an non existing user id
    Then He should get an empty ArrayList

    When An user uses an existing user id, but with no connexions
    Then He should get an empty ArrayList

    When An user uses an existing user id, with at least one connexions
    Then It should get that user's profile DTO
