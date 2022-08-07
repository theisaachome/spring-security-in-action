### The Spring Security offers three types of matcher methods for Authorization configurations:

## Using matcher methods to select endpoints

Three option for matcher methods

- MVC
- Ant
- regex

### MVC matcher Example

ADMIN role can call `/employees`.  
MANAGER role can call only `/products`

```java
@Override
protected void configure(HttpSecurity http) throws Exception {
http.httpBasic();
    http.authorizeRequests()
    // Only calls the path /hello if the user has the ADMIN role
    .mvcMatchers("/employees").hasRole("ADMIN")
    // Only calls the path /ciao if the user has the Manager role
    .mvcMatchers("/products").hasRole("MANAGER");
}
```

---

### `permitAll()` method

The permitAll() method states that all other requests are allowed without authentication.

```java
@Override
protected void configure(HttpSecurity http) throws Exception {
http.httpBasic();
    http.authorizeRequests()
           .mvcMatchers("/hello").hasRole("ADMIN")
           .mvcMatchers("/ciao").hasRole("MANAGER")
           .anyRequest().permitAll();
}
```

---

### `authenticated()` method

Making other requests accessible for all authenticated users
All other requests are accessible only by authenticated users.

```java
@Override
protected void configure(HttpSecurity http) throws Exception {
http.httpBasic();
http.authorizeRequests()
           .mvcMatchers("/hello").hasRole("ADMIN")
           .mvcMatchers("/ciao").hasRole("MANAGER")
           .anyRequest().authenticated();
}
```
