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
    
## Starting your gocd agent

1. The task has been prebuilt for you, just run `./batect start-gocd`. This will
start up a gocd server and agent for you.

2. Head to `localhost:8153` to see if the gocd server has been started.
Check whether the agent has been registered, if it's still in pending state, enable it.

3. !! Sad manual step !! 
    So for some reason, the .ssh file is created under the root user instead of go user.
    
    - Get your server hash:
        ```
        docker ps (get your server hash)
        ```
    - Check your .ssh permissions
        ```
        docker exec -u root [server-hash] bash -c "ls -la /home/go/"
        ```
    - If .ssh belongs to root, run this command to change the owner to go
    
        ```
        docker exec -u root [server-hash] bash -c "chown -R go /home/go/.ssh"
        ```

4. Go to config repo 