package com.igasm.shelter.persistence.dao;

import com.igasm.shelter.persistence.model.Animal;
import com.igasm.shelter.persistence.model.Species;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.List;

@Repository
public class AnimalDAOImpl implements AnimalDAO {

  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sf){
    this.sessionFactory = sf;
  }

  @Override
  public void addAnimal(Animal animal) {
    Session session = this.sessionFactory.getCurrentSession();
    session.persist(animal);

  }

  @Override
  public void updateAnimal(Animal animal) {
    Session session = this.sessionFactory.getCurrentSession();
    session.update(animal);
  }

  @Override
  public void deleteAnimal(Animal animal) {
    Session session = this.sessionFactory.getCurrentSession();
    session.delete(animal);
  }

  @Override
  public List<Animal> listAnimals() {
    Session session = this.sessionFactory.getCurrentSession();
    List<Animal> animals = session.createQuery("from Animal", Animal.class).list();
    return animals;
  }

  @Override
  public Animal getAnimalById(int id) {
    Session session = this.sessionFactory.getCurrentSession();
    Animal animal = session.load(Animal.class, new Integer(id));
    return animal;
  }

  @Override
  public void deleteAnimalById(int id) {
    Session session = this.sessionFactory.getCurrentSession();
    Animal animal = session.load(Animal.class, new Integer(id));
    if(animal != null){
      session.delete(animal);
    }
  }

  @Override
  public List<Animal> listAnimalsBySpecies(Species species){
    Session session = this.sessionFactory.getCurrentSession();
    org.hibernate.query.Query<Animal> animalsQuery = session.createQuery("from Animal a where a.species := species", Animal.class);
    animalsQuery.setParameter("species", species);
    return animalsQuery.list();
  }
}
