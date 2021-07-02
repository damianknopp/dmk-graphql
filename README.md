# dmk-graphql

Simple Graphql test. Uses Spring boot, Graphql, and Spring data
This project's purpose is to demonstrate and supply a reference of Graphql in Java and Spring. Also, to demonstrate a simple Spring JDBC setup. 

## build

```sh
./bin/build.sh
```

## run

```sh
./bin/run.sh
```

Visit the Graphql playground [playground](http://localhost:8080/playground/)
Run the canned queries in the different tabs.

## postmortem
Using Spring JDBC is probably not a good option to use with Graphql since Spring JDBC does not provide lazy loading.
Additionally, setting up models in Java, Graphql and in a Schema is probably not a great approach.

See;

[Spring JDBC](https://spring.io/projects/spring-data-jdbc)

[Graphql Java Kickstart](https://github.com/graphql-java-kickstart)
