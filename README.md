# Spring Framework Web Application Example (Java-based Configuration)

#### 1. Simple Sign-in web application with Spring Security
###### folder: simplesignin
* In memory authentication by user's role
* Preventing user to go back to sign-in page after a successful sign-in


#### 2. Uploading and Downloading files web application
###### folder: uploadingfiles
* Register MultipartConfigElement
* Maximum allowed size for upload files
* Using Spring Framework's MultipartFile to upload files


#### 3. Retrieving data from MySQL Database
###### folder: springjdbc
* Apache Commons DBCP Connection Pool
* Using JdbcTemplate object that injected a repository for running SQL command 


#### 4. Sign-in using MySQL Database
###### folder: signinjdbc
* Apache Commons DBCP Connection Pool
* Using configureGlobal method to authenticate user
* Implementing UserDetailsService interface to authorize user's role
