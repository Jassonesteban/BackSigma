package com.mobile.sigma.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.sigma.domain.Admin;


@Repository
public interface AdminDAO extends CrudRepository<Admin, String> {


}
