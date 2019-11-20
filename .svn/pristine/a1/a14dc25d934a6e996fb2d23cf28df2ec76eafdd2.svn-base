package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.ArticleTypeMapper;
import com.caishen91.jupiter.model.ArticleType;
import com.caishen91.jupiter.service.IArticleTypeService;
import com.caishen91.jupiter.vo.ArticleTypeVO;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleTypeServiceImpl extends BaseService implements IArticleTypeService {


    @Override
    public int getTotalAticleTypeCountByParams(Map queryMap) {
        ArticleTypeMapper aticleTypeMapper = writableSQLSession.getMapper(ArticleTypeMapper.class);
        return aticleTypeMapper.getTotalAticleTypeCountByParams(queryMap);
    }

    @Override
    public List<ArticleType> getAticleTypeByParams(Map queryMap) {
        ArticleTypeMapper aticleTypeMapper = writableSQLSession.getMapper(ArticleTypeMapper.class);
        return aticleTypeMapper.getAticleTypeByParams(queryMap);
    }

    @Override
    public ArticleType getArticleTypetById(int id) {
        ArticleTypeMapper aticleTypeMapper = writableSQLSession.getMapper(ArticleTypeMapper.class);
        return aticleTypeMapper.getArticleTypetById(id);
    }

    @Override
    public boolean setArticleTypeStatus(ArticleType articleType) {
        ArticleTypeMapper aticleTypeMapper = writableSQLSession.getMapper(ArticleTypeMapper.class);
        return aticleTypeMapper.setArticleTypeStatus(articleType);
    }

    @Override
    public int addArticleType(ArticleType articleType) {
        ArticleTypeMapper aticleTypeMapper = writableSQLSession.getMapper(ArticleTypeMapper.class);
        aticleTypeMapper.addArticleType(articleType);
        return articleType.getId();
    }

    @Override
    public boolean updateArticleType(ArticleType articleType) {
        ArticleTypeMapper aticleTypeMapper = writableSQLSession.getMapper(ArticleTypeMapper.class);
        return aticleTypeMapper.updateArticleType(articleType);
    }

    @Override
    public List<ArticleType> getArticleTypets() {
        ArticleTypeMapper aticleTypeMapper = writableSQLSession.getMapper(ArticleTypeMapper.class);
        return aticleTypeMapper.getArticleTypets();
    }

	@Override
	public List<ArticleType> getListByStatus(int status) {
		ArticleTypeMapper aticleTypeMapper = writableSQLSession.getMapper(ArticleTypeMapper.class);
        return aticleTypeMapper.getListByStatus(status);
	}

	@Override
	public List<ArticleTypeVO> getAllTypeByStatus(int status) {
		ArticleTypeMapper aticleTypeMapper = writableSQLSession.getMapper(ArticleTypeMapper.class);
        return aticleTypeMapper.getAllTypeByStatus(status);
	}


}
