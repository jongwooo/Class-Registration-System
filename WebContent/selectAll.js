$( document ).ready( function select(mode) {
	$( '.' + mode + '-all' ).click( function() {
		$( '.' + mode ).prop( 'checked', this.checked );
	} );
} );
