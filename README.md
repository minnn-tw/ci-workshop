# Workshop steps


## Pre-steps

1. For this workshop you will need to have 
    - Docker installed
    - a github account (assuming you already have this since you forked repo)

2. Create a temporary/fake ssh key 
    ```
    ssh-keygen -t rsa -b 4096 -C "ci-workshop"
    /Users/*whoever-you-are*/.ssh/id_rsa-ci-workshop
    ```
    
3. Add this key to your git account (you can remove it after the workshop)
    ```
    cat ~/.ssh/id_rsa-ci-workshop.pub | pbcopy
    ```
    
## Setting up your pipeline config repo

1. The task has been prebuilt for you, just run `./batect start-gocd`. This will
start up a gocd server and agent for you.

2. Head to `localhost:8153` to see if the gocd server has been started.
Check whether the agent has been registered, if it's still in pending state, enable it.

3. !! Sad manual step (But you only have to worry about this if you're setting up .git and not https) !!  
    So for some reason, the .ssh file is created under the root user instead of go user.
    
    - Get your server & agent hash:
        ```
        docker ps
        ```
    - Check your .ssh permissions
        ```
        docker exec [server/agent-hash] bash -c "ls -la /home/go/"
        ```
    - If .ssh belongs to root, run this command to change the owner to go
    
        ```
        docker exec -u root [server/agent-hash] bash -c "chown -R go /home/go/.ssh"
        ```
    - Adding known hosts manually lol
        ```
        docker exec [server/agent-hash] bash -c "ssh-keyscan -H github.com >> ~/.ssh/known_hosts"
        ```

4. Go to config repo and create a new config repo to track. Ours is simple in this case,
our app repo is also our config repo.

    Add a material and name the config repo

    ```
    git@github.com:[repo-name].git
    ```
    OR
    ```
    https://github.com/[username]/[repo-name].git
    ```
    
    Remember to add your pipeline group to the config repo!
    `'Allow'` `'Pipeline group'` `'ciworkshop'`.
    
    Now check if you can see your pipeline/group appear on the dashboard.

6. Pipeline config reference: <https://github.com/tomzo/gocd-yaml-config-plugin#setup>


## Finally! We can finally build our pipeline!
    I'm sorry, haven't done this in ages
    
1. Open `ci-workshop.gocd.yaml`. There is already a pre-existing stage there.

    Your tasks now are: 
    ```
        - Task 1: run hello world in gocd-agent
        - Task 2: write a unit test and include in your pipeline and get it to pass
        ===== < This part probably can't be done on local> =======
        - Task 3: get the pipeline to deploy the app
        - Task 4: More than one environment with diff config
    ```