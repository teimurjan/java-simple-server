# java-simple-server
To turn the server on just run main method of Main class.
After that you can go to localhost:8081.
There you'll see index.html from src/templates/ folder.
Then you can go to localhost:8081/about, what will show you about.html from the same templates folder.
There are only two available routes, that are represented in Settings class.
If you try to go by a wrong route (for example: localhost:8081/wrong) you'll get 404 not found error represented by error_404.html template.
It's just a simple server, but can be easily improved.
