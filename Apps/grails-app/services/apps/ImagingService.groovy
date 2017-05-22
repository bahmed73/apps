package apps

import grails.transaction.Transactional
import ij.ImagePlus;
import ij.io.FileSaver;
import ij.io.Opener;
import ij.plugin.filter.Convolver;
import ij.process.ByteProcessor;
import ij.process.ColorProcessor;
import ij.process.FloatProcessor;
import ij.process.ImageProcessor;
import ij.process.ImageStatistics;
import ij.process.MedianCut;
import ij.process.ShortProcessor;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

@Transactional
class ImagingService {

    def serviceMethod() {

    }
	
	boolean transactional = false
	
		public static final int FILETYPE_UNKNOWN    = 0;
		public static final int FILETYPE_JPEG       = 1;
		public static final int FILETYPE_GIF        = 2;
		public static final int FILETYPE_BMP        = 3;
		public static final int FILETYPE_TIFF       = 4;
		public static final int FILETYPE_PNG        = 5;
		
		//GaussianBlur constants
		private static final int BYTE=0, SHORT=1, FLOAT=2, RGB=3;
		
	
		public static ImagePlus openImagePlus(String input) throws Exception {
			Opener opener       = new Opener();
			ImagePlus impPlus   = opener.openImage(input);
			if (impPlus == null) {
				throw new Exception();
			}
			return impPlus;
		}
	
		public static ImagePlus openImagePlusUrl(String input) throws Exception {
			Opener opener       = new Opener();
			ImagePlus impPlus   = opener.openURL(input);
			if (impPlus == null) {
				throw new Exception();
			}
			return impPlus;
		}
		
		//Set the moveUp flag to true if this method is needed for people photos and there is a risk of too much space getting cut off from the top.
		//If the moveUp is false, then the image will be cropped right int the middle.
		public static void makeImageResizeCrop(ImagePlus image, String input, String output, int size, boolean moveUp) throws Exception {
			
			int fileType = getFileType(input);
			if (fileType == FILETYPE_UNKNOWN) {
				throw new Exception();
			}
	
			//int dimensions[] = image.getDimensions();
			//int width               = dimensions[0];
			//int height              = dimensions[1];
			//String output = input.substring(0, input.lastIndexOf("."))+"-01."+getFileTypeStr(input);
			int width = image.getDimensions()[0]
			int height = image.getDimensions()[1]
			try {
				if (width > height) {
					float ratio = (float) height/width;
					int newHeight  = 0;
					if (height > size) {
						newHeight = size;
						Float newWidth = size/ratio;
						Float reducedWidth = (newWidth-size)/2;
						ImagePlus newImage = makeImage(image, newWidth.intValue(), newHeight);
						ij.process.ImageProcessor newImageProcessor = newImage.getProcessor();
						newImageProcessor.setRoi(reducedWidth.intValue(), 0, size, size);
						ij.process.ImageProcessor cropProcessor = newImageProcessor.crop();
						newImageProcessor.reset();
						ij.ImagePlus impPlusCrop = new ImagePlus("crop", cropProcessor);
						saveFile(impPlusCrop, fileType, output);
						cropProcessor.reset();
					} else if (width > size) {
						int newWidth = size;
						newHeight = (int)(size*ratio);
						ImagePlus newImage = makeImage(image, newWidth, newHeight);
						saveFile(newImage, fileType, output);
					} else {
						saveFile(image, fileType, output);
					}
				} else {
					float ratio = (float) width/height;
					int newWidth = 0;
					if (width > size) {
						newWidth = size;
						Float newHeight = (size/ratio);
						Float reducedHeight = null;
						if (moveUp) {
							reducedHeight = (newHeight-size)/4;
						} else {
							reducedHeight = (newHeight-size)/2;
						}
						ImagePlus newImage = makeImage(image, newWidth, newHeight.intValue());
						ij.process.ImageProcessor newImageProcessor = newImage.getProcessor();
						newImageProcessor.setRoi(0, reducedHeight.intValue(), size, size);
						ij.process.ImageProcessor cropProcessor = newImageProcessor.crop();
						newImageProcessor.reset();
						ij.ImagePlus impPlusCrop = new ImagePlus("crop", cropProcessor);
						saveFile(impPlusCrop, fileType, output);
						cropProcessor.reset();
					} else if (height > size) {
						int newHeight = size;
						newWidth = (int)(size*ratio);
						ImagePlus newImage = makeImage(image, newWidth, newHeight);
						saveFile(newImage, fileType, output);
					} else {
						saveFile(image, fileType, output);
					}
				}
			} catch (Exception e) {
				throw new Exception();
			}
		}
		
		/**
		 * Takes the name of the image as input.  Creates the 100x100 output and return the location.
		 * Set the moveUp flag to true if this method is needed for people photos and there is a risk of too much space getting cut off from the top.
		 * If the moveUp is false, then the image will be cropped right int the middle.
		 *
		 * @param input
		 * @return output
		 */
		public static String generate50x50(ImagePlus image, String input, boolean moveUp) throws Exception {
	
			 int fileType = 0;
			 //not checking file types for now.
			/*int fileType = getFileType(input);
			if (fileType == FILETYPE_UNKNOWN) {
				throw new Exception();
			}*/
	
			//int dimensions[] = image.getDimensions();
			//int width               = dimensions[0];
			//int height              = dimensions[1];
			int width = image.getDimensions()[0]
			int height = image.getDimensions()[1]
			//String output = input.substring(0, input.lastIndexOf('.'))+"-01."+getFileTypeStr(input);
			String output = input + "-02";
	
			
			try {
				if (width > height) {
					float ratio = (float) height/width;
					int newHeight   = 0;
					if (height > 50) {
						newHeight = 50;
						Float newWidth = 50/ratio;
						Float reducedWidth = (newWidth-50)/2;
						ImagePlus newImage = makeImage(image, newWidth.intValue(), newHeight);
						ij.process.ImageProcessor newImageProcessor = newImage.getProcessor();
						newImageProcessor.setRoi(reducedWidth.intValue(), 0, 50, 50);
						ij.process.ImageProcessor cropProcessor = newImageProcessor.crop();
						newImageProcessor.reset();
						ij.ImagePlus impPlusCrop = new ImagePlus("crop", cropProcessor);
						saveFile(impPlusCrop, fileType, output);
						cropProcessor.reset();
					} else if (width > 50) {
						int newWidth = 50;
						newHeight = (int)(50*ratio);
						ImagePlus newImage = makeImage(image, newWidth, newHeight);
						saveFile(newImage, fileType, output);
					} else {
						saveFile(image, fileType, output);
					}
				} else {
					float ratio = (float) width/height;
					int newWidth = 0;
					if (width > 50) {
						newWidth = 50;
						Float newHeight = 50/ratio;
						Float reducedHeight = null;
						
						if (moveUp) {
							reducedHeight = ((newHeight-50)/4);
						} else {
							reducedHeight = (newHeight-50)/2;
						}
						ImagePlus newImage = makeImage(image, newWidth, newHeight.intValue());
						ij.process.ImageProcessor newImageProcessor = newImage.getProcessor();
						newImageProcessor.setRoi(0, reducedHeight.intValue(), 50, 50);
						ij.process.ImageProcessor cropProcessor = newImageProcessor.crop();
						newImageProcessor.reset();
						ij.ImagePlus impPlusCrop = new ImagePlus("crop", cropProcessor);
						saveFile(impPlusCrop, fileType, output);
						cropProcessor.reset();
					} else if (height > 50) {
						int newHeight = 50;
						newWidth = (int)(50*ratio);
						ImagePlus newImage = makeImage(image, newWidth, newHeight);
						saveFile(newImage, fileType, output);
					} else {
						saveFile(image, fileType, output);
					}
				}
			} catch (Exception e) {
				System.out.println("error generating image");
				e.printStackTrace();
			}
			return output;
		}
		
		/**
		 * Takes the name of the image as input.  Creates the 100x100 output and return the location.
		 * Set the moveUp flag to true if this method is needed for people photos and there is a risk of too much space getting cut off from the top.
		 * If the moveUp is false, then the image will be cropped right int the middle.
		 *
		 * @param input
		 * @return output
		 */
		public static String generate100x100(ImagePlus image, String input, boolean moveUp) throws Exception {
	
			 int fileType = 0;
			 //not checking file types for now.
			/*int fileType = getFileType(input);
			if (fileType == FILETYPE_UNKNOWN) {
				throw new Exception();
			}*/
	
			//int dimensions[] = image.getDimensions();
			//int width               = dimensions[0];
			//int height              = dimensions[1];
			int width = image.getDimensions()[0]
			int height = image.getDimensions()[1]
			//String output = input.substring(0, input.lastIndexOf('.'))+"-01."+getFileTypeStr(input);
			String output = input + "-01";
	
			
			try {
				if (width > height) {
					float ratio = (float) height/width;
					int newHeight   = 0;
					if (height > 100) {
						newHeight = 100;
						Float newWidth = 100/ratio;
						Float reducedWidth = (newWidth-100)/2;
						ImagePlus newImage = makeImage(image, newWidth.intValue(), newHeight);
						ij.process.ImageProcessor newImageProcessor = newImage.getProcessor();
						newImageProcessor.setRoi(reducedWidth.intValue(), 0, 100, 100);
						ij.process.ImageProcessor cropProcessor = newImageProcessor.crop();
						newImageProcessor.reset();
						ij.ImagePlus impPlusCrop = new ImagePlus("crop", cropProcessor);
						saveFile(impPlusCrop, fileType, output);
						cropProcessor.reset();
					} else if (width > 100) {
						int newWidth = 100;
						newHeight = (int)(100*ratio);
						ImagePlus newImage = makeImage(image, newWidth, newHeight);
						saveFile(newImage, fileType, output);
					} else {
						saveFile(image, fileType, output);
					}
				} else {
					float ratio = (float) width/height;
					int newWidth = 0;
					if (width > 100) {
						newWidth = 100;
						Float newHeight = 100/ratio;
						Float reducedHeight = null;
						
						if (moveUp) {
							reducedHeight = ((newHeight-100)/4);
						} else {
							reducedHeight = (newHeight-100)/2;
						}
						ImagePlus newImage = makeImage(image, newWidth, newHeight.intValue());
						ij.process.ImageProcessor newImageProcessor = newImage.getProcessor();
						newImageProcessor.setRoi(0, reducedHeight.intValue(), 100, 100);
						ij.process.ImageProcessor cropProcessor = newImageProcessor.crop();
						newImageProcessor.reset();
						ij.ImagePlus impPlusCrop = new ImagePlus("crop", cropProcessor);
						saveFile(impPlusCrop, fileType, output);
						cropProcessor.reset();
					} else if (height > 100) {
						int newHeight = 100;
						newWidth = (int)(100*ratio);
						ImagePlus newImage = makeImage(image, newWidth, newHeight);
						saveFile(newImage, fileType, output);
					} else {
						saveFile(image, fileType, output);
					}
				}
			} catch (Exception e) {
				System.out.println("error generating image");
				e.printStackTrace();
			}
			return output;
		}
		
		/**
		 * Takes the name of the image as input.  Creates the 650x650 output and return the location.
		 *
		 * @param input
		 * @return output
		 */
		public static String generate650x650(ImagePlus image, String input) throws Exception {
			
			int fileType = 0;
			/*int fileType = getFileType(input);
			if (fileType == FILETYPE_UNKNOWN) {
				throw new Exception();
			}*/
	
			//int dimensions[]    = image.getDimensions();
			//int width           = dimensions[0];
			//int height          = dimensions[1];
			int width = image.getDimensions()[0]
			int height = image.getDimensions()[1]
			
			String output = input.substring(0, input.lastIndexOf('.'))+"-02."+getFileTypeStr(input);
			try {
				int newWidth = 0;
				int newHeight = 0;
				if (width > 650 || height > 650 ) {
					if (width > height) {
						newWidth = 650;
						float ratio = (float)height/width;
						newHeight = (int) (650*ratio);
					} else {
						newHeight = 650;
						float ratio = (float)width/height;
						newWidth = (int)(650 * ratio);
					}
					ImagePlus newImage = makeImage(image, newWidth, newHeight);
					saveFile(newImage, fileType, output);
				} else if (width <= 650 && height <= 650) {
					saveFile(image, fileType, output);
				}
			} catch (Exception e) {
				throw new Exception();
			}
			return output;
		}
	
		//TODO fix the below method.  Groovy doesn't like do while loops
		/**
		 * Takes the name of the image as input.  Creates the output (if > 2M, shrinks it) and return the location.
		 *
		 * @param input
		 * @return output filename
		 */
		public static String generateOriginal(ImagePlus image, String input) throws Exception {
			
			int fileType = 0;
			/*int fileType = getFileType(input);
			if (fileType == FILETYPE_UNKNOWN) {
				throw new Exception();
			}*/
	
	//      int dimensions[]    = image.getDimensions();
			//int width           = dimensions[0];
			//int height          = dimensions[1];
			int width = image.getDimensions()[0]
			int height = image.getDimensions()[1]
			//String output = input.substring(0, input.lastIndexOf('.'))+"-03."+getFileTypeStr(input);
			
			String output = input + "-03";
			
			try {
				float compareFrequency = 0.2F
				float megaLength    = 0;
				float divisible     = 1 + compareFrequency;
				
				File imageFile = null;
				imageFile = new File(input);
				megaLength = (float) imageFile.length()/1000000;
				int newWidth = 0;
				int newHeight = 0;
				if (megaLength > 2) {
					if (width > height) {
						newWidth = (int)(width/divisible);
						float ratio = (float)height/width;
						newHeight = (int) (newWidth*ratio);
					} else {
						newHeight = (int) (height/divisible);
						float ratio = (float)width/height;
						newWidth = (int)(newHeight * ratio);
					}
					ImagePlus newImage = makeImage(image, newWidth, newHeight);
					saveFile(newImage, fileType, output);
				} else {
					saveFile(image, fileType, output);
				}
				
				imageFile = new File(output);
				megaLength = (float) imageFile.length()/1000000;
				divisible+=compareFrequency;
					
				while (megaLength > 2) {
					imageFile = null;
					imageFile = new File(input);
					megaLength = (float) imageFile.length()/1000000;
					newWidth = 0;
					newHeight = 0;
					if (megaLength > 2) {
						if (width > height) {
							newWidth = (int)(width/divisible);
							float ratio = (float)height/width;
							newHeight = (int) (newWidth*ratio);
						} else {
							newHeight = (int) (height/divisible);
							float ratio = (float)width/height;
							newWidth = (int)(newHeight * ratio);
						}
						ImagePlus newImage = makeImage(image, newWidth, newHeight);
						saveFile(newImage, fileType, output);
					} else {
						saveFile(image, fileType, output);
					}
					
					imageFile = new File(output);
					megaLength = (float) imageFile.length()/1000000;
					divisible+=compareFrequency;
				}
					
			} catch (Exception e) {
				throw new Exception();
			}
			return output;
		}
	//save 650 image wihout any resizing. use -02 as extension
	public static String generate650Original(ImagePlus image, String input, String filename) throws Exception {
			
			int fileType = getFileType(filename);
			if (fileType == FILETYPE_UNKNOWN) {
				throw new Exception();
			}
	
	//      int dimensions[]    = image.getDimensions();
			//int width           = dimensions[0];
			//int height          = dimensions[1];
			int width = image.getDimensions()[0]
			int height = image.getDimensions()[1]
			String output = filename.substring(0, filename.lastIndexOf('.'))+"-02."+getFileTypeStr(filename);
			System.out.println("the output is "+output);
			try {
				float compareFrequency = 0.2F
				float megaLength    = 0;
				float divisible     = 1 + compareFrequency;
				
				File imageFile = null;
				imageFile = new File(input);
				megaLength = (float) imageFile.length()/1000000;
				int newWidth = 0;
				int newHeight = 0;
				if (megaLength > 2) {
					if (width > height) {
						newWidth = (int)(width/divisible);
						float ratio = (float)height/width;
						newHeight = (int) (newWidth*ratio);
					} else {
						newHeight = (int) (height/divisible);
						float ratio = (float)width/height;
						newWidth = (int)(newHeight * ratio);
					}
					ImagePlus newImage = makeImage(image, newWidth, newHeight);
					saveFile(newImage, fileType, output);
				} else {
					saveFile(image, fileType, output);
				}
				
				imageFile = new File(output);
				megaLength = (float) imageFile.length()/1000000;
				divisible+=compareFrequency;
					
				while (megaLength > 2) {
					imageFile = null;
					imageFile = new File(input);
					megaLength = (float) imageFile.length()/1000000;
					newWidth = 0;
					newHeight = 0;
					if (megaLength > 2) {
						if (width > height) {
							newWidth = (int)(width/divisible);
							float ratio = (float)height/width;
							newHeight = (int) (newWidth*ratio);
						} else {
							newHeight = (int) (height/divisible);
							float ratio = (float)width/height;
							newWidth = (int)(newHeight * ratio);
						}
						ImagePlus newImage = makeImage(image, newWidth, newHeight);
						saveFile(newImage, fileType, output);
					} else {
						saveFile(image, fileType, output);
					}
					
					imageFile = new File(output);
					megaLength = (float) imageFile.length()/1000000;
					divisible+=compareFrequency;
				}
					
			} catch (Exception e) {
				throw new Exception();
			}
			return output;
		}
		
		/**
		 * Takes the name of the image as input.  Save the file in the output name passed in.  Takes the width and height, and creates the image.
		 * It preserves the ratio.  For example, if 800x400 photo is passed in, and the width and height is 100x100, then it would create a
		 * 100x50 photo.
		 *
		 * @param input
		 * @return output
		 */
		public static String generateImage50(ImagePlus image, String output, boolean moveUp) throws Exception {
			
			 int fileType = 0;
			//int dimensions[]    = image.getDimensions();
			//int width           = dimensions[0];
			//int height          = dimensions[1];
			int width = image.getDimensions()[0]
			int height = image.getDimensions()[1]
			
			try {
				if (width > height) {
					float ratio = (float) height/width;
					int newHeight   = 0;
					if (height > 50) {
						newHeight = 50;
						Float newWidth = 50/ratio;
						Float reducedWidth = (newWidth-50)/2;
						ImagePlus newImage = makeImage(image, newWidth.intValue(), newHeight);
						ij.process.ImageProcessor newImageProcessor = newImage.getProcessor();
						newImageProcessor.setRoi(reducedWidth.intValue(), 0, 50, 50);
						ij.process.ImageProcessor cropProcessor = newImageProcessor.crop();
						newImageProcessor.reset();
						ij.ImagePlus impPlusCrop = new ImagePlus("crop", cropProcessor);
						saveFile(impPlusCrop, fileType, output);
						cropProcessor.reset();
					} else if (width > 50) {
						int newWidth = 50;
						newHeight = (int)(50*ratio);
						ImagePlus newImage = makeImage(image, newWidth, newHeight);
						saveFile(newImage, fileType, output);
					} else {
						saveFile(image, fileType, output);
					}
				} else {
					float ratio = (float) width/height;
					int newWidth = 0;
					if (width > 50) {
						newWidth = 50;
						Float newHeight = 50/ratio;
						Float reducedHeight = null;
						
						if (moveUp) {
							reducedHeight = ((newHeight-50)/4);
						} else {
							reducedHeight = (newHeight-50)/2;
						}
						ImagePlus newImage = makeImage(image, newWidth, newHeight.intValue());
						ij.process.ImageProcessor newImageProcessor = newImage.getProcessor();
						newImageProcessor.setRoi(0, reducedHeight.intValue(), 50, 50);
						ij.process.ImageProcessor cropProcessor = newImageProcessor.crop();
						newImageProcessor.reset();
						ij.ImagePlus impPlusCrop = new ImagePlus("crop", cropProcessor);
						saveFile(impPlusCrop, fileType, output);
						cropProcessor.reset();
					} else if (height > 50) {
						int newHeight = 50;
						newWidth = (int)(50*ratio);
						ImagePlus newImage = makeImage(image, newWidth, newHeight);
						saveFile(newImage, fileType, output);
					} else {
						saveFile(image, fileType, output);
					}
				}
			} catch (Exception e) {
				System.out.println("error generating image");
				e.printStackTrace();
			}
			return output;
		}
		
		public static String generateImage100(ImagePlus image, String output, boolean moveUp) throws Exception {
			
			 int fileType = 0;
			//int dimensions[]    = image.getDimensions();
			//int width           = dimensions[0];
			//int height          = dimensions[1];
			int width = image.getDimensions()[0]
			int height = image.getDimensions()[1]
			
			try {
			   if (width > height) {
				   float ratio = (float) height/width;
				   int newHeight   = 0;
				   if (height > 100) {
					   newHeight = 100;
					   Float newWidth = 100/ratio;
					   Float reducedWidth = (newWidth-100)/2;
					   ImagePlus newImage = makeImage(image, newWidth.intValue(), newHeight);
					   ij.process.ImageProcessor newImageProcessor = newImage.getProcessor();
					   newImageProcessor.setRoi(reducedWidth.intValue(), 0, 100, 100);
					   ij.process.ImageProcessor cropProcessor = newImageProcessor.crop();
					   newImageProcessor.reset();
					   ij.ImagePlus impPlusCrop = new ImagePlus("crop", cropProcessor);
					   saveFile(impPlusCrop, fileType, output);
					   cropProcessor.reset();
				   } else if (width > 100) {
					   int newWidth = 100;
					   newHeight = (int)(100*ratio);
					   ImagePlus newImage = makeImage(image, newWidth, newHeight);
					   saveFile(newImage, fileType, output);
				   } else {
					   saveFile(image, fileType, output);
				   }
			   } else {
				   float ratio = (float) width/height;
				   int newWidth = 0;
				   if (width > 100) {
					   newWidth = 100;
					   Float newHeight = 100/ratio;
					   Float reducedHeight = null;
					   
					   if (moveUp) {
						   reducedHeight = ((newHeight-100)/4);
					   } else {
						   reducedHeight = (newHeight-100)/2;
					   }
					   ImagePlus newImage = makeImage(image, newWidth, newHeight.intValue());
					   ij.process.ImageProcessor newImageProcessor = newImage.getProcessor();
					   newImageProcessor.setRoi(0, reducedHeight.intValue(), 100, 100);
					   ij.process.ImageProcessor cropProcessor = newImageProcessor.crop();
					   newImageProcessor.reset();
					   ij.ImagePlus impPlusCrop = new ImagePlus("crop", cropProcessor);
					   saveFile(impPlusCrop, fileType, output);
					   cropProcessor.reset();
				   } else if (height > 100) {
					   int newHeight = 100;
					   newWidth = (int)(100*ratio);
					   ImagePlus newImage = makeImage(image, newWidth, newHeight);
					   saveFile(newImage, fileType, output);
				   } else {
					   saveFile(image, fileType, output);
				   }
			   }
		   } catch (Exception e) {
			   System.out.println("error generating image");
			   e.printStackTrace();
		   }
		   return output;
		}
		
		public static String generateImage650(ImagePlus image, String output, boolean moveUp) throws Exception {
			
			 int fileType = 0;
			//int dimensions[]    = image.getDimensions();
			//int width           = dimensions[0];
			//int height          = dimensions[1];
			int width = image.getDimensions()[0]
			int height = image.getDimensions()[1]
			
			try {
			  if (width > height) {
				  float ratio = (float) height/width;
				  int newHeight   = 0;
				  if (height > 650) {
					  newHeight = 650;
					  Float newWidth = 650/ratio;
					  Float reducedWidth = (newWidth-650)/2;
					  ImagePlus newImage = makeImage(image, newWidth.intValue(), newHeight);
					  ij.process.ImageProcessor newImageProcessor = newImage.getProcessor();
					  newImageProcessor.setRoi(reducedWidth.intValue(), 0, 650, 650);
					  ij.process.ImageProcessor cropProcessor = newImageProcessor.crop();
					  newImageProcessor.reset();
					  ij.ImagePlus impPlusCrop = new ImagePlus("crop", cropProcessor);
					  saveFile(impPlusCrop, fileType, output);
					  cropProcessor.reset();
				  } else if (width > 650) {
					  int newWidth = 650;
					  newHeight = (int)(650*ratio);
					  ImagePlus newImage = makeImage(image, newWidth, newHeight);
					  saveFile(newImage, fileType, output);
				  } else {
					  saveFile(image, fileType, output);
				  }
			  } else {
				  float ratio = (float) width/height;
				  int newWidth = 0;
				  if (width > 650) {
					  newWidth = 650;
					  Float newHeight = 650/ratio;
					  Float reducedHeight = null;
					  
					  if (moveUp) {
						  reducedHeight = ((newHeight-650)/4);
					  } else {
						  reducedHeight = (newHeight-650)/2;
					  }
					  ImagePlus newImage = makeImage(image, newWidth, newHeight.intValue());
					  ij.process.ImageProcessor newImageProcessor = newImage.getProcessor();
					  newImageProcessor.setRoi(0, reducedHeight.intValue(), 650, 650);
					  ij.process.ImageProcessor cropProcessor = newImageProcessor.crop();
					  newImageProcessor.reset();
					  ij.ImagePlus impPlusCrop = new ImagePlus("crop", cropProcessor);
					  saveFile(impPlusCrop, fileType, output);
					  cropProcessor.reset();
				  } else if (height > 650) {
					  int newHeight = 650;
					  newWidth = (int)(650*ratio);
					  ImagePlus newImage = makeImage(image, newWidth, newHeight);
					  saveFile(newImage, fileType, output);
				  } else {
					  saveFile(image, fileType, output);
				  }
			  }
		  } catch (Exception e) {
			  System.out.println("error generating image");
			  e.printStackTrace();
		  }
		  return output;
		}
	
		/**
		 * Takes the name of the image as input.  Save the file in the output name passed in.  Takes the width and height, and creates the image.
		 * It preserves the ratio.  For example, if 800x400 photo is passed in, and the width and height is 100x100, then it would create a
		 * 100x50 photo.
		 *
		 * @param input
		 * @return output
		 */
		public static String generateImage(ImagePlus image, String output, int boxWidth, int boxHeight) throws Exception {
			
			 int fileType = 0;
			//int dimensions[]    = image.getDimensions();
			//int width           = dimensions[0];
			//int height          = dimensions[1];
			int width = image.getDimensions()[0]
			int height = image.getDimensions()[1]
			
			try {
				int newWidth = 0;
				int newHeight = 0;
				if (width > boxWidth || height > boxHeight ) {
					if (width > height) {
						newWidth = boxWidth;
						float ratio = (float)height/width;
						newHeight = (int) (boxWidth*ratio);
					} else {
						newHeight = boxHeight;
						float ratio = (float)width/height;
						newWidth = (int)(boxHeight * ratio);
					}
					ImagePlus newImage = makeImage(image, newWidth, newHeight);
					saveFile(newImage, fileType, output);
				} else if (width <= boxWidth && height <= boxHeight) {
					saveFile(image, fileType, output);
				}
			} catch (Exception e) {
				throw new Exception();
			}
			return output;
		}
		
		//this method is created specifically for profile images.  The size is 100x140.  The width should never be more than 100, even though the
		//height intially could be less than 140.  This is why a new method needed to be written.
		public static String generateProfileImage(ImagePlus image, String input, String output) throws Exception {
			
			int fileType = getFileType(input);
			if (fileType == FILETYPE_UNKNOWN) {
				throw new Exception();
			}
	
			//int dimensions[]    = image.getDimensions();
			//int width           = dimensions[0];
			//int height          = dimensions[1];
			int width = image.getDimensions()[0]
			int height = image.getDimensions()[1]
			
			try {
				int newWidth = 0;
				int newHeight = 0;
				if (width > 100 || height > 140 ) {
					if (width > 100) {
						newWidth = 100;
						float ratio = (float)height/width;
						newHeight = (int) (newWidth*ratio);
						if (newHeight > 140) {
							newHeight = 140;
							ratio = (float)width/height;
							newWidth = (int) (newHeight*ratio);
						}
					} else {
						newHeight = 140;
						float ratio = (float)width/height;
						newWidth = (int)(newHeight * ratio);
					}
					//ImagePlus newImage = makeImage(impPlus, newWidth, newHeight, true, true);
					ImagePlus newImage = makeImage(image, newWidth, newHeight);
					saveFile(newImage, fileType, output);
				} else {
					saveFile(image, fileType, output);
				}
			} catch (Exception e) {
				throw new Exception();
			}
			return output;
		}
		
	//  this method is created specifically for profile images.  The size is 100x140.  The width should never be more than 100, even though the
		//height intially could be less than 140.  This is why a new method needed to be written.
		public static String generateVideoImage(ImagePlus image, String input, String output, int sizeWidth, int sizeHeight) throws Exception {
			
			int fileType = getFileType(input);
			if (fileType == FILETYPE_UNKNOWN) {
				throw new Exception();
			}
	
			//int dimensions[]    = image.getDimensions();
			//int width           = dimensions[0];
			//int height          = dimensions[1];
			int width = image.getDimensions()[0]
			int height = image.getDimensions()[1]
			
			try {
				int newWidth = 0;
				int newHeight = 0;
				if (width > sizeWidth || height > sizeHeight ) {
					if (width > sizeWidth) {
						newWidth = sizeWidth;
						float ratio = (float)height/width;
						newHeight = (int) (newWidth*ratio);
						if (newHeight > sizeHeight) {
							newHeight = sizeHeight;
							ratio = (float)width/height;
							newWidth = (int) (newHeight*ratio);
						}
					} else {
						newHeight = sizeHeight;
						float ratio = (float)width/height;
						newWidth = (int)(newHeight * ratio);
					}
					//ImagePlus newImage = makeImage(impPlus, newWidth, newHeight, true, true);
					ImagePlus newImage = makeImage(image, newWidth, newHeight);
					saveFile(newImage, fileType, output);
				} else {
					saveFile(image, fileType, output);
				}
			} catch (Exception e) {
				throw new Exception();
			}
			return output;
		}
		
		//supported files types are, jpeg (jpg), gif, tiff, bmp, and png.
		//more filetypes can be added very easily.
		
		private static int getFileType(String filename){
			
			int occur = filename.lastIndexOf('.');
			if (occur != -1) {
				String fileTypeStr = filename.substring(occur+1);
				return getFileTypeByExtension(fileTypeStr);
			}
			return FILETYPE_UNKNOWN;
		}
		
		public static int getFileTypeByExtension(String extension) {
			if ("jpg".equalsIgnoreCase(extension) || "jpeg".equalsIgnoreCase(extension)){
				return FILETYPE_JPEG;
			} else if ("gif".equalsIgnoreCase(extension)) {
				return FILETYPE_GIF;
			} else if ("bmp".equalsIgnoreCase(extension)) {
				return FILETYPE_BMP;
			} else if ("tiff".equalsIgnoreCase(extension) || "tif".equalsIgnoreCase(extension)){
				return FILETYPE_TIFF;
			} else if ("png".equalsIgnoreCase(extension)){
				return FILETYPE_PNG;
			} else
				return FILETYPE_UNKNOWN;
		}
		
		public static String getExtensionByFileType(int fileType) {
			if (fileType == FILETYPE_JPEG) {
				return ".jpg";
			} else if (fileType == FILETYPE_GIF) {
				return ".gif";
			} else if (fileType == FILETYPE_BMP) {
				return ".bmp";
			} else if (fileType == FILETYPE_TIFF) {
				return ".tif";
			} else if (fileType == FILETYPE_PNG) {
				return ".png";
			} else
				return null;
		}
		
		//this method is not checking whether the . exists because it has already been verified in the getFileType method.
		private static String getFileTypeStr(String filename){
			
			return filename.substring(filename.lastIndexOf('.')+1);
		}
		
		public static boolean isAllowableImage(String imageName){
	
			Opener opener = new Opener();
			ImagePlus impPlus = opener.openImage(imageName);
	
			return impPlus != null;
		}
		
		//TODO old save File method
		/*private static void saveFile(ImagePlus image, int fileType, String filename) throws Exception{
			
			if (fileType == FILETYPE_GIF) {
				//just saving the gif won't do.  need to reduce the colors to 8-bit.
				ImageProcessor ip = image.getProcessor();
				ip = reduceColors(ip, 256);
				image = new ImagePlus("enhanced", ip);
			}
	
			ij.io.FileSaver fileSaver = new FileSaver(image);
			
			if (fileType == FILETYPE_JPEG) {
				fileSaver.saveAsJpeg(filename);
			} else if (fileType == FILETYPE_GIF){
				fileSaver.saveAsGif(filename);
			} else if (fileType == FILETYPE_BMP) {
				fileSaver.saveAsBmp(filename);
			} else if (fileType == FILETYPE_TIFF){
				fileSaver.saveAsTiff(filename);
			} else if (fileType == FILETYPE_PNG) {
				//fileSaver.saveAsPng(filename);
				//because of a bug in imageJ handling png saving, we have to do this a little different way.
				int width = image.getWidth();
				int  height = image.getHeight();
				BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics2D g = (Graphics2D)bi.getGraphics();
				g.drawImage(image.getImage(), 0, 0, null);
				File f = new File(filename);
				try {
					ImageIO.write(bi, "png", f);
				} catch (IOException e) {
					throw new Exception();
				}
			}
		}*/
	   
		private static void saveFile(ImagePlus image, int fileType, String filename) throws Exception{
			
			ij.io.FileSaver fileSaver = new FileSaver(image);
			fileSaver.saveAsJpeg(filename);
		}
		
		/* Converts the specified image to an image 8-bit indexed color image of the specied width. */
		public static ImagePlus makeImage(ImagePlus imp, int width2, int height2) {
			
			if (imp==null)
				return null;
			ImageProcessor ip = imp.getProcessor();
			
			double smoothFactor = 1.0;
			int width = ip.getWidth();
			int height = ip.getHeight();
			int[] pixel = new int[3];
			int[] sum = new int[3];
			double xscale, yscale;
			int w, h;
			double product;
			xscale = (double)width/width2;
			yscale = (double)height/height2;
			w = (int)(xscale*smoothFactor);
			h = (int)(yscale*smoothFactor);
			product = w*h;
			ImageProcessor ip2 = ip.createProcessor(width2, height2);
			for (int y=0; y<height2; y++) {
				for (int x=0; x<width2; x++) {
					for (int i=0; i<3; i++) sum[i] = 0;
					int xbase = (int)(x*xscale);
					int ybase = (int)(y*yscale);
					for (int y2=0; y2<h; y2++) {
						for (int x2=0;  x2<w; x2++) {
							pixel = ip.getPixel(xbase+x2, ybase+y2, pixel);
							for (int i=0; i<3; i++)
								sum[i] += pixel[i];
						}
					}
					for (int i=0; i<3; i++)
						sum[i] = (int)(sum[i]/product+0.5);
					ip2.putPixel(x, y, sum);
				}
			}
			ip.reset();
			//return new ImagePlus("enhanced", ip2);
			return runContractEnhancer(new ImagePlus("enhanced", ip2), false, 0.1);
		}
		
		/*
		 *
		 * Gaussian Blur algorithms.  I got this algorithm from ImageJ site.  It was a plugin that I modified into Java class.  We won't use this right now.
		 * This definitely make the image very clear.  However, there is a performance penalty to pay.  If I don't use the algorithm, I can generate
		 * three sizes of the image in 3-4 seconds.  If I use this algorithm, the generation goes up to 7-8 seconds.
		 *
		 * 12/12/05 - Bilal
		 */
		public static ImageProcessor runGaussianblur(ImageProcessor ip, double radius) {
			Rectangle rect = ip.getRoi();
			ImageProcessor ip2 = ip;
	//        System.out.println("rect.width"+rect.width);
	//        System.out.println("ip.getWidth"+ip.getWidth());
	//        System.out.println("rect.height"+rect.height);
	//        System.out.println("ip.getHeight()"+ip.getHeight());
			
			boolean isRoi = rect.width!=ip.getWidth()||rect.height!=ip.getHeight();
	//        System.out.println("isRoi = " + isRoi);
			boolean nonRectRoi = ip.getMask()!=null;
	//        System.out.println("nonRectRoi = " + nonRectRoi);
			
			if (isRoi) {
				ip2.setRoi(rect);
				ip2 = ip2.crop();
			}
			int type;
			if (ip2 instanceof ByteProcessor)
				type = BYTE;
			else if (ip2 instanceof ShortProcessor)
				type = SHORT;
			else if (ip2 instanceof FloatProcessor)
				type = FLOAT;
			else
				type = RGB;
			float[] kernel = makeKernel(radius);
			
			if (type==RGB) {
	//            System.out.println("RGB");
				
					if (nonRectRoi) {
						ip2.snapshot();
						blurRGB(ip2, kernel);
						ip2.reset(ip.getMask());
					} else {
	//                    System.out.println("calling blurRGB");
						ip2 = blurRGB(ip2, kernel);
					}
					if (nonRectRoi)
						ip2.reset(ip.getMask());
					if (isRoi)
						ip.insert(ip2, rect.x, rect.y);
					
					//return !canceled;
					return ip2;
			}
			ip2.setCalibrationTable(null);
			ip2 = ip2.convertToFloat();
			ip2 = blurFloat(ip2, kernel);
			if (nonRectRoi)
				ip.snapshot();
			switch (type) {
				case BYTE:
					ip2 = ip2.convertToByte(false);
					ip.insert(ip2, rect.x, rect.y);
					break;
				case SHORT:
					ip2 = ip2.convertToShort(false);
					ip.insert(ip2, rect.x, rect.y);
					break;
				case FLOAT:
					if (isRoi)
						ip.insert(ip2, rect.x, rect.y);
					break;
			}
			if (nonRectRoi)
				ip.reset(ip.getMask());
			return ip2;
			//return !canceled;
		}
	
		private static ImageProcessor reduceColors(ImageProcessor ip, int nColors) {
			if (ip instanceof ByteProcessor && nColors==256)
				return ip;
			ip = ip.convertToRGB();
			MedianCut mc = new MedianCut((int[])ip.getPixels(), ip.getWidth(), ip.getHeight());
			Image img = mc.convert(nColors);
			return(new ByteProcessor(img));
		}
		
		private static ImageProcessor blurFloat(ImageProcessor ip, float[] kernel) {
			//System.out.println("Inside blurFloat, canceled = " + canceled);
			
			//if (canceled) return;
			Convolver c = new Convolver();
			if (!c.convolve(ip, kernel, kernel.length, 1)) {
				//canceled=true;
				return ip;
			}
			ip.snapshot();
			if (!c.convolve(ip, kernel,1, kernel.length)) {
				//canceled=true;
				return ip;
			}
			
			return ip;
		}
		
		private static ImageProcessor blurRGB(ImageProcessor ip, float[] kernel) {
	//        System.out.println("inside blurrgb");
			
			int width = ip.getWidth();
			int height = ip.getHeight();
			int size = width*height;
			byte[] r = new byte[size];
			byte[] g = new byte[size];
			byte[] b = new byte[size];
			((ColorProcessor)ip).getRGB(r,g,b);
			ImageProcessor rip = new ByteProcessor(width, height, r, null);
			ImageProcessor gip = new ByteProcessor(width, height, g, null);
			ImageProcessor bip = new ByteProcessor(width, height, b, null);
			ImageProcessor ip2 = rip.convertToFloat();
			blurFloat(ip2, kernel);
			ImageProcessor r2 = ip2.convertToByte(false);
			ip2 = gip.convertToFloat();
			blurFloat(ip2, kernel);
			ImageProcessor g2 = ip2.convertToByte(false);
			ip2 = bip.convertToFloat();
			blurFloat(ip2, kernel);
			ImageProcessor b2 = ip2.convertToByte(false);
			((ColorProcessor)ip).setRGB((byte[])r2.getPixels(), (byte[])g2.getPixels(), (byte[])b2.getPixels());
			
			return ip;
		}
	
		private static float[] makeKernel(double radius) {
			radius += 1;
			int size = (int)radius*2+1;
			float[] kernel = new float[size];
	
			for (int i=0; i<size; i++) {
				kernel[i] = (float)Math.exp(-0.5*(sqr((i-radius)/(radius*2)))/sqr(0.2));
			}
	
			float[] kernel2 = new float[size-2];
			System.arraycopy(kernel, 1, kernel2, 0, size - 2);
			if (kernel2.length==1) {
				kernel2[0] = 1f;
			}
	
			return kernel2;
		}
	
		private static double sqr(double x) {return x*x;}
		
		
		
		/*
		 *
		 * Contrast Enhancer algorithms
		 *
		 * I got this algorithm from ImageJ.  I had to modify it a little bit to get to work in our environment.  This algorithm is necessary to make the
		 * images look crisp!
		 *
		 * 12/12/05 - Bilal
		 *
		 */
		private static ImagePlus runContractEnhancer(ImagePlus impPlus, boolean equalize, double saturated) {
			impPlus.trimProcessor();
			
			if (equalize) {
				impPlus = equalize(impPlus);
			} else {
				impPlus = stretchHistogram(impPlus, saturated);
			}
	
			if (equalize) {
				impPlus.getProcessor().resetMinAndMax();
			}
			
			return impPlus;
		}
		
		private static ImagePlus stretchHistogram(ImagePlus imp, double saturated) {
			ImageStatistics stats = null;
			ImageProcessor ip = imp.getProcessor();
			stats = ImageStatistics.getStatistics(ip, ImageStatistics.MIN_MAX, null);
			return new ImagePlus("Histogram", stretchHistogram(ip, saturated, stats));
		}
	
			private static ImageProcessor stretchHistogram(ImageProcessor ip, double saturated, ImageStatistics stats) {
			int hmin, hmax;
			int threshold;
			int[] histogram = stats.histogram;
			if (saturated>0.0)
				threshold = (int)(stats.pixelCount*saturated/200.0);
			else
				threshold = 0;
			int i = -1;
			boolean found = false;
			int count = 0;
			
			i++;
			count += histogram[i];
			found = count>threshold;
				
			while (!found && i<255) {
				i++;
				count += histogram[i];
				found = count>threshold;
			}
			hmin = i;
					
			i = 256;
			count = 0;
			
			i--;
			count += histogram[i];
			found = count>threshold;
			
			while (!found && i>0) {
				i--;
				count += histogram[i];
				found = count>threshold;
				//IJ.log(i+" "+count+" "+found);
			}
			
			hmax = i;
					
			//IJ.log(hmin+" "+hmax+" "+threshold);
			if (hmax>hmin) {
				double min = stats.histMin+hmin*stats.binSize;
				double max = stats.histMin+hmax*stats.binSize;
				ip = normalize(ip, min, max);
			}
			
			return ip;
		}
		
		private static ImageProcessor normalize(ImageProcessor ip, double min, double max) {
			int max2 = 255;
			int range = 256;
			if (ip instanceof ShortProcessor) {
				max2 = 65535;
				range=65536;
			} else if (ip instanceof FloatProcessor) {
				ip = normalizeFloat(ip, min, max);
			}
			
			//double scale = range/max-min);
			int[] lut = new int[range];
			for (int i=0; i<range; i++) {
				if (i<=min) {
					lut[i] = 0;
				} else if (i>=max) {
					lut[i] = max2;
				} else {
					lut[i] = (int)(((i-min)/(max-min))*max2);
				}
			}
			ip.applyTable(lut);
			
			return ip;
		}
	
		private static ImageProcessor normalizeFloat(ImageProcessor ip, double min, double max) {
			double scale = max>min?1.0/(max-min):1.0;
			int size = ip.getWidth()*ip.getHeight();
			float[] pixels = (float[])ip.getPixels();
			double v;
			for (int i=0; i<size; i++) {
				v = pixels[i] - min;
				if (v<0.0) v = 0.0;
				v *= scale;
				if (v>1.0) v = 1.0;
				pixels[i] = (float)v;
			
			}
			
			return ip;
		}
	
		private static ImagePlus equalize(ImagePlus imp) {
			if (imp.getBitDepth()==32) {
				//System.out.println("Contrast Enhancer - Equalization of 32-bit images not supported.");
				return null;
			}
			return new ImagePlus("Equalize", equalize(imp.getProcessor()));
		}
	
		/**
			Changes the tone curves of images.
			It should bring up the detail in the flat regions of your image.
			Histogram Equalization can enhance meaningless detail and hide
			important but small high-contrast features. This method uses a
			similar algorithm, but uses the square root of the histogram
			values, so its effects are less extreme. Hold the alt key down
			to use the standard histogram equalization algorithm.
			This code was contributed by Richard Kirk (rak@cre.canon.co.uk).
		*/
		private static ImageProcessor equalize(ImageProcessor ip) {
		
			int max, range;
			
			int[] histogram = ip.getHistogram();
			ip.resetRoi();
			if (ip instanceof ShortProcessor) { // Short
				max = 65535;
				range = 65535;
			} else { //bytes
				max = 255;
				range = 255;
			}
			
			double sum;
			
			sum = getWeightedValue(histogram, 0);
			for (int i=1; i<max; i++)
				sum += 2 * getWeightedValue(histogram, i);
			sum += getWeightedValue(histogram, max);
			
			double scale = range/sum;
			int[] lut = new int[range+1];
			
			lut[0] = 0;
			sum = getWeightedValue(histogram, 0);
			for (int i=1; i<max; i++) {
				double delta = getWeightedValue(histogram, i);
				sum += delta;
				lut[i] = (int)Math.round(sum*scale);
				sum += delta;
			}
			lut[max] = max;
			
			ip.applyTable(lut);
			
			return ip;
		}
	
		private static double getWeightedValue(int[] histogram, int i) {
			int h = histogram[i];
			if (h<2) return h;
			return Math.sqrt((h));
		}
	
}
