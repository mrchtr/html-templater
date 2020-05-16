# html-templater-service project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

Service which provides a simple html-templater. Two endpoint are available. 

- POST /api/convert
- POST /api/convert/pdf

Both endpoints takes the accept the same payload. 

```json
{
"html": "<div>Hello World! {{name}} </div>",
"placeholder": {
  "name" : "Morty"
  }
}
```  

The service will replacing the placeholder (default given in double brackets) with the specific given values.  
The response of the first endpoint is the plain html code. Second one provides a PDF download. 

Example api call:
```shell script
curl --location --request POST 'localhost:8080/api/convert' \
--header 'Content-Type: application/json' \
--header 'Content-Type: application/json' \
--data-raw '{	
	"html": "<div>Hello World! {{name}}</div>",
	"placeholder": {
		"name": "Morty"
	}
}'
```

## Running Service with Docker

Run container directly with use of docker.

```shell script
docker pull docker.pkg.github.com/mrchtr/html-templater/app:0.0.3
docker run -i --rm -p 8080:8080 docker.pkg.github.com/mrchtr/html-templater/app:0.0.3
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `html-templater-service-0.0.1-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/html-templater-service-0.0.1-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/html-templater-service-0.0.1-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.