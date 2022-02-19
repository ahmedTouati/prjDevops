resource "null_resource" "cluster" {

provisioner "local-exec" {
    command = "docker-compose up"
}
}