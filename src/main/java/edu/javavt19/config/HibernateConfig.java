package edu.javavt19.config;

import edu.javavt19.dao.*;
import edu.javavt19.dao.hibernate.*;
import edu.javavt19.model.AgentModel;
import edu.javavt19.model.BranchOfficeModel;
import edu.javavt19.model.ContractModel;
import edu.javavt19.model.InsuranceTypeModel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:application.properties"})
@ComponentScan({"edu.javavt19"})
public class HibernateConfig {

    @Autowired
    private DataSource dataSource;

    //Hibernate configuration
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan(new String[] { "edu.javavt19.model.hibernate" });
        return sessionFactory;
    }


    @Bean
    @Autowired
    public HibernateTransactionManager hibernateTransactionManager( SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }

    @Bean
    public GenericDAO<ContractModel> getContractDAO() { return new GenericHibernateImpl<>(); }
    @Bean
    public GenericDAO<InsuranceTypeModel> getInsuranceTypeHibernateDAO() { return new GenericHibernateImpl<>(); }
    @Bean
    public GenericDAO<BranchOfficeModel> getOfficeHibernateImpl() { return new GenericHibernateImpl<>(); }
    @Bean
    public GenericDAO<AgentModel> getAgentHibernateImpl() { return new GenericHibernateImpl<>(); }
}