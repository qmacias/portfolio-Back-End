package org.qmacias.project.portfolio.img.application;

import org.qmacias.project.portfolio.img.domain.Image;
import org.qmacias.project.portfolio.img.domain.ImageRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    private final ImageRepository repository;

    public ImageServiceImpl(final ImageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Image> all() {
        return repository.findAll();
    }

    @Override
    public Image get(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Image add(final Image image) {
        return repository.save(image);
    }

    @Override
    public void remove(final Long id) {
        repository.deleteById(id);
    }

}
