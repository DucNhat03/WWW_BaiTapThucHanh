package iuh.filters;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ImageConversionFilter
 */
@WebFilter("/*") // Ánh xạ tất cả các URL
public class ImageConversionFilter extends HttpFilter implements Filter {

    public ImageConversionFilter() {
        super();
    }

    @Override
    public void destroy() {
        // Giải phóng tài nguyên nếu cần
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (req.getRequestURI().endsWith(".jpg")) {
            // Chuyển đổi định dạng hình ảnh từ JPG sang PNG
            BufferedImage image = ImageIO.read(req.getInputStream());
            res.setContentType("image/png");
            OutputStream out = res.getOutputStream();
            ImageIO.write(image, "png", out);
            out.close();
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        // Khởi tạo tài nguyên nếu cần
    }
}

