# UserMicroService

## To Do
* Password Encryption (Bcrypt)
* Session Management
* User Bookmarks (set/get bookmarks)
* Followers/Following
* Notifications

# Ocean Social Media App
Revature social network application to connect and interact with friends

## Members:
* David Burton
* Kevin Dian
* Milo Cao
* Roel Crodua
* Tommy Arnette

## Resource Links:

    (deployed link to website)

## Repositories
   * Front End - https://github.com/Ocean-Social-Media-App/Frontend.git
   * User Microservice - https://github.com/Ocean-Social-Media-App/UserMicroService.git
   * Feed Microservice - https://github.com/Ocean-Social-Media-App/Feed-Service.git
   * Eureka - https://github.com/Ocean-Social-Media-App/Eureka.git
   * Gateway - https://github.com/Ocean-Social-Media-App/gateway.git
   * JWT - https://github.com/Ocean-Social-Media-App/JWT.git


## Project Parameters
Users Can:

    Register
        Email with a welcome email.
    Login/Logout.
    Reset their password.
        Email new password if they forgot password.
    Modify their information.
    Upload a profile picture (using AWS: S3).
    Search other people.
    Create a post.
        Image(s) can be added to these posts (using AWS: S3).
    View his own profile.
        Including posts.
    View others’ profile.
        Including posts.
    See their feed.
        Posts of everyone should show here.
        Pagination should be implemented (only fetching 20 posts at a time).
    Like someone’s post.
        Old school Facebook, only one type of like.

## Roles:
Fill In Member Roles

## Programs/Libraries used:

### BackEnd:

    Spring MVC
    Hibernate
    Java
    Postgres
    AWS EC2
    AWS S3
    Junit/Mockito/H2
    Log4J
    Javadoc
    Microservice

### FrontEnd:

    Angular
    TypeScript
    JavaScript
    Jasmine

### Deployment:

    AWS EC2
    Docker
    Jenkins

## Backend Requirements
Tests:
* JUnit
* Mockito

Hibernate:

    Models
    PostgreSQL

Register, Models, and Database

    Sessions
    register- email password
    forgot password will email them their temp pass
    Modify info

    Dummy email
    Google interface for handling email
    AWS S3 upload a picture- handle saving URL to database

### Backend endpoints (Non-finishedl list)

|   Action        |             Endpoint                |
|   ------        |             --------                |
|  Login 	        |   `POST /api/user/login`            |
|  Logout 	      |   `GET /api//user/logout`           |
|  Session        |   `GET /api/user/check-session`     |
|  Sign Up        |   `POST /api/user/user`             |
|  Forgot 	      |   `GET /api/user/forgot/{username}` |
|  Update Profile | 	`PUT /api/user/updateUser`        |

## Models (Non-finished list)
### User Model
```
    Integer Id: serial
    String firstname not null
    String lastname not null
    String username Unique not null
    String password not null
    String email Unique not null
    String aboutMe char(250)
    Date bday int
    String proPicUrl
    Long lastNotification
    Set<Integer> bookmarks
    Set<Integer> user_following
    Set<Integer> followers
```
