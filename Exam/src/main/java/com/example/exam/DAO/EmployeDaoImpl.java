package com.example.exam.DAO;

import com.example.exam.model.Employe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class EmployeDaoImpl implements EmployeDao{
    private EntityManagerFactory emf;
    private EntityManager em ;
    private List<Employe> employes;
    public EmployeDaoImpl() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }
    public List<Employe> selectAll(){
        //Query query = em.createNativeQuery("SELECT * FROM personne", Employe.class);
        Query query = em.createQuery("SELECT s FROM Employe s", Employe.class);
        List<Employe> employes;
        EmployeDaoImpl.this.employes = query.getResultList();
        System.out.println("Liste des étudiants :");
        for (Employe s : EmployeDaoImpl.this.employes) {
            System.out.println(s);
        }
        return EmployeDaoImpl.this.employes;
    }
    public boolean addLine(Employe emp){
        if(true){

            // Démarrez une transaction
            em.getTransaction().begin();

            // Ajoutez l'instance de l'étudiant à l'EntityManager
            em.persist(emp);

            // Validez et finalisez la transaction
            em.getTransaction().commit();
            return true;
        }else {return false;}
    }

    public boolean delete(int id){
        Employe studentToDelete = em.find(Employe.class, id);
        if(studentToDelete != null){
            em.getTransaction().begin();
            em.remove(studentToDelete);
            em.getTransaction().commit();
            return true;
        }else{
            return false;
        }
    }

    public void close(){
        em.close();
        emf.close();
    }
    public Employe find(Long id ){
        return em.find(Employe.class, id);
    }

    public List<Employe> selectOne(String condition){
        Query query = em.createQuery("SELECT s FROM Employe s WHERE s.name >= :naaaame", Employe.class);
        query.setParameter("naaaame", condition);
        List<Employe> employes = query.getResultList();
        return EmployeDaoImpl.this.employes;
    }
}
