# False positive for XXE_SCHEMA_FACTORY

Compile and run spotbugs:

```
mvn compile
mvn spotbugs:spotbugs
```

Observe in target/spotbugsXml.xml that there's exactly 2 bugs with `type='XXE_SCHEMA_FACTORY'`.

Note that this bug occurs in SchemaCreatorCreateAndConfigureInSeparateMethod.java and SchemaCreatorConfigureInSeparateMethod.java, but not in SchemaCreatorInlined.java.
