//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import liquibase.integration.cdi.CDILiquibaseConfig;
//import liquibase.integration.cdi.annotations.LiquibaseType;
//import liquibase.resource.ClassLoaderResourceAccessor;
//import liquibase.resource.ResourceAccessor;
//
//import javax.enterprise.context.ApplicationScoped;
//import javax.enterprise.inject.Produces;
//import javax.sql.DataSource;
//
//@ApplicationScoped
//public class LiquibaseConfig {
//
//    @Produces
//    @LiquibaseType
//    public CDILiquibaseConfig createConfig() {
//        CDILiquibaseConfig config = new CDILiquibaseConfig();
//        config.setChangeLog("db.changelog/db.changelog.yaml");
//        return config;
//    }
//
//    @Produces
//    @LiquibaseType
//    public DataSource createDataSource() {
//        HikariConfig config = new HikariConfig();
//        config.setDriverClassName("org.postgresql.Driver");
//        config.setJdbcUrl("jdbc:postgresql://localhost:5433/postgres");
//        config.setUsername("postgres");
//        config.setPassword("Darisae12");
//
//        return new HikariDataSource(config);
//    }
//
//    @Produces
//    @LiquibaseType
//    public ResourceAccessor create() {
//        return new ClassLoaderResourceAccessor(getClass().getClassLoader());
//    }
//
//}
