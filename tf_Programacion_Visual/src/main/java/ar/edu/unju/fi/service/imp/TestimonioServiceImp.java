package ar.edu.unju.fi.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Testimonio;

import ar.edu.unju.fi.repository.ITestimonioRepository;
import ar.edu.unju.fi.service.ITestimonioService;

@Service
public class TestimonioServiceImp implements ITestimonioService{
	
	@Autowired
    private ITestimonioRepository testimonioRepository;
	@Autowired
	private Testimonio testimonio;

	@Override
	public List<Testimonio> getListaT() {
        return testimonioRepository.findByEstado(true);
    }

	@Override
	public void guardarTestimonio(Testimonio testimonio) {
		testimonio.setEstado(true);
		testimonioRepository.save(testimonio);
		// TODO Auto-generated method stub

	}

	@Override
	public Testimonio getBy(Long id){
		return testimonioRepository.findById(id).get();
	}



	@Override
	public void eliminarTestimonio(Testimonio testimonioEncontrado) {
		testimonioEncontrado.setEstado(false);
		testimonioRepository.save(testimonioEncontrado);
	}

	@Override
	public Testimonio getTestimonio() {
		LocalDate fechaActual = LocalDate.now();
		testimonio.setFecha(fechaActual);
		return testimonio;
	}
	
    @Override
    public Testimonio getByUserId(Long userId) {
        return testimonioRepository.findByUsuarioId(userId);
    }


}
