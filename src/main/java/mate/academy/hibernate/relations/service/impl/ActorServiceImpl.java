package mate.academy.hibernate.relations.service.impl;

import jakarta.persistence.EntityNotFoundException;
import mate.academy.hibernate.relations.dao.ActorDao;
import mate.academy.hibernate.relations.dao.impl.ActorDaoImpl;
import mate.academy.hibernate.relations.model.Actor;
import mate.academy.hibernate.relations.service.ActorService;
import mate.academy.hibernate.relations.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class ActorServiceImpl implements ActorService {
    private static ActorDao actorDao;

    public ActorServiceImpl(SessionFactory sessionFactory) {
        actorDao = new ActorDaoImpl(HibernateUtil.getInstance());
    }

    @Override
    public Actor add(Actor actor) {
        return actorDao.add(actor);
    }

    @Override
    public Actor get(Long id) {
        return actorDao.get(id).orElseThrow(
                () -> new EntityNotFoundException("DB don't have actor with such id = " + id));
    }
}
