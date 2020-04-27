CI Debug Notes
================
To validate some circleci stuff, I was able to run a “build locally” using the steps below.
The local build runs in a docker container.

  * (Once) Install circleci client (`brew install circleci`)

  * Convert the “real” config.yml into a self contained (non-workspace) config via:

        circleci config process .circleci/config.yml > .circleci/local-config.yml

  * Run a local build with the following command:
          
        circleci local execute -c .circleci/local-config.yml --job 'github-maven-deploy/build-and-test'

    With the above command, operations that cannot occur during a local build will show an error like this:
     
      ```
      ... Error: FAILED with error not supported
      ```
    
      However, the build will proceed and can complete “successfully”, which allows you to verify scripts in your config, etc.
      
      If the build does complete successfully, you should see a happy yellow `Success!` message.

  * You can perform a release by pushing a git tag as shown below.
  
    1. Checkout/pull the latest `master` branch, and create a new tag with the desired semantic version and a helpful note:
      
           git tag -a v0.1.x -m "Helpful message in tag."
             
    2. Push the tag up:
      
           git push origin v0.1.x
             
    3. There is no step 3.
