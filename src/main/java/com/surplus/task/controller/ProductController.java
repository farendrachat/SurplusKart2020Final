package com.surplus.task.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.surplus.task.domain.ImageModel;
import com.surplus.task.domain.Product;
import com.surplus.task.dto.ImagesResponse;
import com.surplus.task.dto.ProductResponse;
import com.surplus.task.dto.ProductsResponse;
import com.surplus.task.dto.Response;
import com.surplus.task.service.ImageService;
import com.surplus.task.service.ProductService;
import com.surplus.task.utils.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/product")
@Api(value="Surplus Kart", description="Operations pertaining to products in Application") 
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ImageService imageService;
	
//	@Autowired
//	ProductController(ProductService productService,ImageService imageService)
//	{
//		this.productService = productService;
//		this.imageService = imageService;
//	}
	
	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(value="/products",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductsResponse listProduct()
	{
//		Iterable<Product> listProduct = productService.list();
//		return listProduct;
		logger.info("Get all Products request received");
		ProductsResponse response=new ProductsResponse();
		response.setMessage(Constants.SUCCESS);
		response.setStatus(Constants.SUCCESS);
		response.setProducts(productService.list());
		logger.info("Get all Products completed with details : "+response.getProducts());
		return response;
	}
	
	@ApiOperation(value = "Get product for seller id", response = Product.class)
	@GetMapping("/getProductForSeller/{sellerId}")
	public ProductsResponse getProductForSeller(@PathVariable int sellerId)
	{
		List<Product> lstProduct = productService.getProductBySellerId(sellerId) ;
		ProductsResponse response=new ProductsResponse();
		if(lstProduct!=null && lstProduct.size()>0) {
		response.setMessage(Constants.SUCCESS);
		response.setStatus(Constants.SUCCESS);
		response.setProducts(lstProduct);
		}
		else {
			response.setMessage(Constants.PRODUCT_NOT_FOUND);
			response.setStatus(Constants.FAILURE);			
		}		
		return response;
	}
	
	@ApiOperation(value = "Get product for buyer id", response = Product.class)
	@GetMapping("/getProductForBuyer/{buyerId}")
	public ProductsResponse getProductForBuyer(@PathVariable int buyerId)
	{
		List<Product> lstProduct = productService.getProductByBuyerId(buyerId) ;
		ProductsResponse response=new ProductsResponse();
		if(lstProduct!=null && lstProduct.size()>0) {
		response.setMessage(Constants.SUCCESS);
		response.setStatus(Constants.SUCCESS);
		response.setProducts(lstProduct);
		}
		else {
			response.setMessage(Constants.PRODUCT_NOT_FOUND);
			response.setStatus(Constants.FAILURE);			
		}		
		return response;
	}
	
	@ApiOperation(value = "Save", response = Boolean.class)
	@CrossOrigin
	@PostMapping(path="/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse saveProduct(@RequestBody Product product)
	{		
		logger.info("Add new Product request received with Product details : "+product);
		ProductResponse response=new ProductResponse();
		Product addedProduct=productService.save(product);
		response.setMessage(Constants.PRODUCT_ADDED_SUCCSESSFULLY);
		response.setStatus(Constants.SUCCESS);
		response.setProduct(addedProduct);
		logger.info("Add new Product request completed with Product details : "+addedProduct);
		return response;
	}
	
	
	@Transactional
	@ApiOperation(value = "Save/Update array of images", response = Boolean.class)
	@CrossOrigin
	@PostMapping(path="/saveImages",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)	   
	public ImagesResponse saveImages(@RequestParam("pic1") MultipartFile pic1,@RequestParam(required=false) MultipartFile pic2,
			@RequestParam(required=false) MultipartFile pic3,@RequestParam(required=false) MultipartFile pic4,@RequestParam("coa") MultipartFile coa,
			@RequestParam("msds") MultipartFile msds,@RequestParam("specificationSheet") MultipartFile specificationSheet,@RequestParam("productId")
	        Integer productId)
	{		
		ImagesResponse imagesResponse = new ImagesResponse();
		ImageModel pic1ImageModel=null;
		ImageModel pic2ImageModel=null;
		ImageModel pic3ImageModel=null;
		ImageModel pic4ImageModel=null;
		ImageModel coaImageModel=null;
		ImageModel msdsImageModel=null;
		ImageModel specificationSheetImageModel=null;
		List<ImageModel> mandatoryImages = null;
		List<ImageModel> optionalImages=new ArrayList<ImageModel>(); 
		try {
			
			pic1ImageModel = new ImageModel(productId,pic1.getOriginalFilename(),"pic1",pic1.getContentType(),pic1.getBytes());
			coaImageModel = new ImageModel(productId,coa.getOriginalFilename(),"coa",coa.getContentType(),coa.getBytes() );
			msdsImageModel = new ImageModel(productId, msds.getOriginalFilename(),"msds",msds.getContentType(),msds.getBytes() );
			specificationSheetImageModel = new ImageModel(productId, specificationSheet.getOriginalFilename(),"specificationSheet",
					specificationSheet.getContentType(),specificationSheet.getBytes() );
			mandatoryImages = Arrays.asList(pic1ImageModel,coaImageModel,msdsImageModel,specificationSheetImageModel);
			
			
			if(pic2!=null) {
			pic2ImageModel = new ImageModel(productId, pic2.getOriginalFilename(),"pic2",pic2.getContentType(),pic2.getBytes() );
			optionalImages.add(pic2ImageModel);
			}
			if(pic3!=null) {
			pic3ImageModel = new ImageModel(productId, pic3.getOriginalFilename(),"pic3",pic3.getContentType(),pic3.getBytes() );
			optionalImages.add(pic3ImageModel);
			}
			if(pic4!=null) {
			pic4ImageModel = new ImageModel(productId, pic4.getOriginalFilename(),"pic4",pic4.getContentType(),pic4.getBytes() );
			optionalImages.add(pic4ImageModel);
			}
			
			imageService.saveAll(mandatoryImages);
			imagesResponse.setStatus(true);
			if(optionalImages!=null && optionalImages.size()>0)
			{
				imagesResponse.setStatus(imageService.saveAll(optionalImages));	
			}
			
			if(imagesResponse.isStatus()) {
				imagesResponse.setMessage(Constants.IMAGES_ADDED_SUCCSESSFULLY);
				imagesResponse.setImages(imageService.getImagesByProductId(productId));				
			}
			else {
				imagesResponse.setStatus(false);
				imagesResponse.setMessage(Constants.FAILURE);				
			}
			
		} catch (IOException e) {
            logger.error("IO Exception thrown is:"+e);
            imagesResponse.setStatus(false);
            imagesResponse.setMessage(Constants.FAILURE);
	}
		return imagesResponse;
       
	}
	

	
	@DeleteMapping(value = "/deleteProduct/{prId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Response deleteProduct(@PathVariable int prId) {
		logger.info("Delete Product request received with id : "+prId);
		Response response = new Response();
		boolean isDeleted = productService.deleteProduct(prId);		
		response.setMessage(Constants.PRODUCT_DELETED_SUCCESSFULLY);
		response.setStatus(Constants.SUCCESS);
		logger.info("Delete Product request completed with id : "+prId);
		return response;
	}
	
	@GetMapping(value="/getProduct/{prId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse getProduct(@PathVariable Integer prId) {
		logger.info("Get User request received with id : "+prId);
		ProductResponse response=new ProductResponse();
		response.setMessage(Constants.SUCCESS);
		response.setStatus(Constants.SUCCESS);
		response.setProduct(productService.getProduct(prId));
		logger.info("Get User request completed with User details : "+response.getProduct());
		return response;
	}
	
	@GetMapping(value="/getImages/{prId}")
	public List<ImageModel> getImages(@PathVariable Integer prId) {
		logger.info("Get Images request received for product id : "+prId);
		List<ImageModel> imageList  = new ArrayList<ImageModel>(); 
		final List<ImageModel> retrievedImage  = imageService.getImagesByProductId(prId);
		for(int count=0;count<retrievedImage.size();count++)
		{
	    ImageModel imgModel = new ImageModel(retrievedImage.get(count).getProductId(),retrievedImage.get(count).getImageName(),
	    		retrievedImage.get(count).getPicType(),retrievedImage.get(count).getImageType(),retrievedImage.get(count).getPic());
	    imageList.add(imgModel);
		}
		logger.info("Get Images request completed");
		return imageList;
	}

}
