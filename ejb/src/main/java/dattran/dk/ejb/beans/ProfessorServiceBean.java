package dattran.dk.ejb.beans;

import java.util.List;

import javax.ejb.Stateless;

import com.querydsl.jpa.impl.JPAQuery;

import dattran.dk.domain.entities.ProfessorEntity;
import dattran.dk.domain.entities.QProfessorEntity;
import dattran.dk.ejb.filters.Filter;
import dattran.dk.ejb.filters.ProfessorFilter;
import dattran.dk.ejb.interfaces.ProfessorServiceLocal;
import dattran.dk.ejb.interfaces.ProfessorServiceRemote;

/**
 * Session Bean implementation class ProfessorServiceBean
 */
@Stateless(name = "ProfessorService", mappedName = "ProfessorService")
public class ProfessorServiceBean extends AbstractServiceBean<Integer, ProfessorEntity> implements
		ProfessorServiceRemote, ProfessorServiceLocal {

	@Override
	public Class<ProfessorEntity> getEntityClass() {
		return ProfessorEntity.class;
	}

	@Override
	public List<ProfessorEntity> find(Filter filter) {
		ProfessorFilter professorFilter = (ProfessorFilter) filter;
		QProfessorEntity professor = QProfessorEntity.professorEntity;
		JPAQuery<ProfessorEntity> query = new JPAQuery<ProfessorEntity>(em);
		query.from(professor);

		return query.fetch();
	}
}
