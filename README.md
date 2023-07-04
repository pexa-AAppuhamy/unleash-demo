# Unleash React + Kotlin Spring Boot Demo

### Getting Started
## React UI demo
NOTE: If not using batect will need node version >= 18.
1. Install depedencies for react ui:
    `./batect ui:install`

2. Install dependencies for unleash proxy server:
    `./batect proxy:install`

3. Run proxy server:
    `./batect run:proxy`

4. In another terminal run React ui:
    `./batect run:ui`

5. In a third terminal run unleash server:
    `docker compose up`

6. The unleash console should open if not navigate to [localhost:4242](http://localhost:4242)

7. Login to unleash with default credentials: <br>
    username: `admin` <br>
    password: `unleash4all`

8. Navigate to `Feature toggles` page and click on button `New feature toggle`

9. Name the feature toggle logo and click `Create feature toggle` button.

10. In the default project dashboard you should see the created feature toggle. Now it can toggled on or off with highlighted switch.

![toggle](/screenshots/toggle.png)

11. There is 3 second delay set for the react ui. When logo feature is toggled on the vite and react logo should appear.

## Kotlin Springboot Demo
The following Springboot will demo the unleash toggle where when the toggle named `usersfromDB` is toggled on will fetch users from the connected database. If the feature is toggled off it will fetch users from an external api which in this case is a wiremock server.
Run the following with the unleash server already running (step 5 from React UI demo).

1. Create the feature toggled named `usersFromDB` (step 8 and 9 from React UI demo)

1. Run the postgres database
    `./batect run:db`
2. Connect to database and create a schema named demo:
    `CREATE SCHEMA demo`

2. Generate OpenAPI Kotlin Springboot code
    `./batect api-generate`

3. Run springboot application, it will also run the wiremock server.  
    `./batect run:backend`

4. Call the API endpoint `http://localhost:8080/api/v1/users` using curl or Postman, see that the response has the id property is of the format `user_id_<random_number>`.

5. Switch on the `usersfromDB` feature toggle, wait 3 seconds and invoke the API endpoint again, this time you will see that the id is of the UUID format. 