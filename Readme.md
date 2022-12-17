## SA55 Oracle Technical Assessment

### Instructions on how to build and run the container
1. From terminal/cmd, cd into the project folder
2. Enter docker build -t fibonacci . 
3. Enter docker run -p 2000:80 fibonacci
4. The container will be hosted on port 2000. 
Send a http get request with the json object to localhost:2000/fibonacci to receive the correct response.