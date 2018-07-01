package br.com.agsouza.cheersmicroservice.dto;

public class DiskSpace {
	 private String status;
	 private float total;
	 private float free;
	 private float threshold;

	 public String getStatus() {
	  return status;
	 }

	 public float getTotal() {
	  return total;
	 }

	 public float getFree() {
	  return free;
	 }

	 public float getThreshold() {
	  return threshold;
	 }

	 public void setStatus(String status) {
	  this.status = status;
	 }

	 public void setTotal(float total) {
	  this.total = total;
	 }

	 public void setFree(float free) {
	  this.free = free;
	 }

	 public void setThreshold(float threshold) {
	  this.threshold = threshold;
	 }
}