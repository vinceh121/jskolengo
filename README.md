<p align="center">
  <img src="https://github.com/The-Rabbit-Team/.github/blob/master/banners/jskolengo.png?raw=true" />
</p>

Unofficial Java wrapper for the new Skolengo mobility API

Part of The Rabbit Team: https://discord.gg/9u69mxsFT6

## Using
Use this [Maven repository](https://maven.vinceh121.me/#/snapshots)
```xml
<repository>
  <id>vinceh121-snapshots</id>
  <name>vinceh121's Maven repository</name>
  <url>https://maven.vinceh121.me/snapshots</url>
</repository>
```

And add this [dependency](https://maven.vinceh121.me/#/snapshots/me/vinceh121/jskolengo/wrapper)
```xml
<dependency>
  <groupId>me.vinceh121.jskolengo</groupId>
  <artifactId>wrapper</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```

Example usage:
```java
JSkolengoAnonymous anon = new JSkolengoAnonymous();

// Collections by pagination, limit and offset
JSONAPIDocument<List<School>> schools = anon.searchSchools("Jules Ferry", 0, 10);
System.out.println(schools);

// Collections by iterable
for (School sch : anon.searchSchools("Jules Ferry")) {
  System.out.println(sch);
}

// Collections by Java Stream
anon.searchSchools("Jules Ferry").stream().forEach(System.out::println);

// Authenticated endpoints
JSkolengo sko = new JSkolengo();
sko.setBearerToken("aaa.bbb.ccc"); // JWT access token, obtained thought OpenID Connect, see https://github.com/maelgangloff/scolengo-token
sko.setEmsCode("entmip"); // See School#getEmsCode

sko.fetchAgendas(LocalDate.now(), LocalDate.now().plusDays(14)).stream().forEach(System.out::println);
```
