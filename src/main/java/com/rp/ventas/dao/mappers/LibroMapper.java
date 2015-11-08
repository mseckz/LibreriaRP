package com.rp.ventas.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rp.ventas.dao.models.Libro;

public class LibroMapper implements RowMapper<Libro> {

	public Libro mapRow(ResultSet rs, int arg1) throws SQLException {
		Libro libro = new Libro();
		libro.setIdLibro(rs.getInt("idLibro"));
		libro.setNombreLibro(rs.getString("nombreLibro"));
		libro.setDescripcion(rs.getString("descripcion"));
		libro.setPrecio(rs.getDouble("precio"));
		libro.setAutor(rs.getString("autor"));
		libro.setCategoria(rs.getInt("categoria"));
		libro.setEstado(rs.getBoolean("estado"));
		return libro;
	}

}
