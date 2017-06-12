package com.shaw.shop.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.shaw.shop.mapper.ArticleMapper;
import com.shaw.shop.model.Article;

@Service
public class ArticleService {

	@Autowired
	private ArticleMapper articleMapper;

	public List<Article> findAllArticle() {
		return articleMapper.selectAll();
	}

	public List<Article> findArticleByPage(Article article) {
		if (article.getPage() != null && article.getRows() != null) {
			PageHelper.startPage(article.getPage(), article.getRows());
		}
		return articleMapper.selectAll();
	}

	public Article getArticleById(Long id) {
		return articleMapper.selectByPrimaryKey(id);
	}

}
