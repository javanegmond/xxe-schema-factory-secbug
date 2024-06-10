# False positive for XXE_SCHEMA_FACTORY

Compile and run spotbugs:

```
mvn compile
mvn spotbugs:spotbugs
```

Observe in target/spotbugsXml.xml that there's exactly 1 bug with `type='XXE_SCHEMA_FACTORY'`.

Note that this bug occurs in SchemaCreatorWithSeparateMethod.java, but not in SchemaCreatorInlined.
