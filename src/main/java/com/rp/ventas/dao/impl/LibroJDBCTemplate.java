package com.rp.ventas.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rp.ventas.dao.interfaces.LibroDAO;
import com.rp.ventas.dao.mappers.LibroMapper;
import com.rp.ventas.dao.models.Libro;

public class LibroJDBCTemplate implements LibroDAO{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
	
	@Override
	public void grabar(Libro libro) {
		int out = 0;
		if(libro.getIdLibro() == null){
			String sql = "INSERT INTO libro (nombreLibro, descripcion, precio, stock, autor, categoria) VALUES "
					+ "(?,?,?,?,?,?)";
			out = jdbcTemplateObject.update(sql, new Object[]{libro.getNombreLibro(),
													    libro.getDescripcion(), 
													    libro.getPrecio(),
													    libro.getStock(), 
													    libro.getAutor(), 
													    libro.getCategoria()});
		} else {
			String sql = "UPDATE libro set nombreLibro = ?, descripcion = ?, "
					+ "precio = ?, stock = ?, autor = ?, categoria = ? where idLibro = ?";
			out = jdbcTemplateObject.update(sql, libro.getNombreLibro(),libro.getDescripcion(),libro.getPrecio(),
					libro.getStock(),libro.getAutor(),libro.getCategoria(), libro.getIdLibro());
		}
		
		if(out != 0){
			System.out.println("Libro se guardo con id: " + libro.getIdLibro());
		} else {
			System.out.println("Error al guardar");
		}
	}
	
	@Override
	public Libro buscarPorId(Integer id) {
		String sql = "select * from libro where idLibro = ?";
		Libro libro = jdbcTemplateObject.queryForObject(sql, new Object[]{id}, new LibroMapper() );
		return libro;
	}

	@Override
	public List<Libro> listarLibros() {
		String sql = "Select * from libro";
		List<Libro> libros = jdbcTemplateObject.query(sql, new LibroMapper());
		return libros;
	}

	
	
	
	
}
