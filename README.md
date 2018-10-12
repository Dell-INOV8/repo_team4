# DELL CONNECT v0.0.1

Dell Connect is a machine learning powered internal social and professional platform to connect team members of Dell HQ by specific interests. The user begins by creating personal profiles specifying employee information. (ie. name, email, building location, team, etc.) Users customize their profile by ranking various interests from 0-10. Dell Connect suggests matches to users based on similar interests suggesting one on one meet ups, backed by k means clustering. At any time users are able to reflect their network on their profile by friending users.

### Modes

Dell Connect features two modes to connect users: career mode + after hours mode. In career mode, users rank interests pertaining to career aspirations and interests. These interests include management, technology, business, etc. In after hours mode, users rank interests reflecting hobbies after work. These interests include hiking, gaming, cooking, etc.

### Prototype
In this version of Dell Connect, the "Your Profile" and "Your Interests" tabs are implemented. This version currently allows the user to input their name, position, email and bio in the "Your Profile" tab. The user can rate their professional interests and the hobbies in the "Your Interests" tab. However, these front end features still need to be connected with the backend. In the backend, the k means clustering algorithm for matching, the database to store user information, and the profile class is fully implemented.

### Future Implementations
To continue on with our project, we need to connect the front-end input, i.e. grabbing the user information from the website, to the backend processing. The "Discover" and "Connect" tabs are to be implemented. A wider range of professional and social interests will be added, as well as the ability for more profile customization. "Connect" will be the feature that matches employees based on the ratings of their professional/social interests. With the "Discover" feature, users will be able to search for other employees to friend by name, interests, position, etc, as well as friend those they met through the matching process. 


## Built With

* [Netbeans](https://netbeans.org/downloads/start.html?platform=macosx&lang=en&option=javaee) - Web App host + IDE
* [Primefaces](https://www.primefaces.org/#primefaces) - UI developer tool
* [MySQL Workbench](https://dev.mysql.com/doc/workbench/en/) - Database

## Authors

* **Ana Ashrafi**
* **Chance Stovall**
* **John Nguyen**
* **Paulina Kuo**
