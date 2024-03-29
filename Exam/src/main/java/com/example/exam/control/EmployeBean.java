package com.example.exam.control;

import com.example.exam.model.Employe;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import com.example.exam.DAO.EmployeDao;
import com.example.exam.DAO.EmployeDaoImpl;

import java.io.IOException;
import java.util.List;

@ManagedBean
@ViewScoped
public class EmployeBean {
    private List<Employe> employes ;
    private EmployeDao employeDao;

    private Employe employe;

    public EmployeBean() {
        employeDao = new EmployeDaoImpl();
    }
    public EmployeBean(EmployeDao userDao) {
        this.employeDao = employeDao;
    }

    public List<Employe> selectEmployes(){
        employes =  employeDao.selectAll();
        return employes;
    }

    public void deleteEmploye(int id){
        boolean deleted = employeDao.delete(id);
        if (deleted){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"la ligne a ete supprimer avec succees",""));
        }else {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"la ligne n'a pas ete supprimer avec succees",""));
        }

    }



    public List<Employe> selectEmploye(String cond){
        List<Employe> slt = employeDao.selectOne(cond);
        return slt;
    }

    public void closeEm(){
        employeDao.close();
    }

    public Employe findEmploye(long id){
        return employeDao.find(id);

    }

    public void redirectToHomePage() throws IOException {

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("firstpage.xhtml");
        } catch (IOException e) {
            e.printStackTrace(); // Gérer l'exception de redirection
        }
    }


}
