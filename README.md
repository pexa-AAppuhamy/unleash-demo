## Unleash React + Kotlin Spring Boot Demo

### Getting Started
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
