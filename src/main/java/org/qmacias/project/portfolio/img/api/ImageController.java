package org.qmacias.project.portfolio.img.api;

import org.qmacias.project.portfolio.img.domain.Image;
import org.qmacias.project.portfolio.img.application.ImageService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
final class ImageController {

    private final ImageService service;

    ImageController(final ImageService service) {
        this.service = service;
    }

    @GetMapping
    public List<Image> allImages() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Image getImage(@PathVariable final Long id) {
        return service.get(id);
    }

    @PostMapping
    public Image addImage(@RequestBody final Image image) {
        return service.add(image);
    }

    @DeleteMapping("/{id}")
    public void removeImage(@PathVariable final Long id) {
        service.remove(id);
    }

}
